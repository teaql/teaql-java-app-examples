package com.teaql.vending.compose

import com.doublechaintech.vendingmachineservice.Q
import io.teaql.core.meta.SimpleEntityMetaFactory
import io.teaql.provider.jdbc.JdbcSqlExecutor
import io.teaql.runtime.TeaQLRuntime
import org.postgresql.ds.PGSimpleDataSource
import org.testcontainers.containers.PostgreSQLContainer

fun main() {
    println("Starting PostgreSQL Testcontainer...")
    val postgres = PostgreSQLContainer<Nothing>("postgres:15-alpine").apply {
        withDatabaseName("vending")
        withUsername("test")
        withPassword("test")
        start()
    }
    
    println("Initializing TeaQLManager with PostgreSQL...")
    val customLogSink = GlobalLiveLogsSink()
    
    val metaFactory = SimpleEntityMetaFactory()
    com.doublechaintech.vendingmachineservice.EntityMetaRegistry().assemble(metaFactory)
    io.teaql.core.meta.EntityMetaFactory.registerGlobal(metaFactory)
    
    val dataSource = PGSimpleDataSource()
    dataSource.setUrl(postgres.jdbcUrl)
    dataSource.user = postgres.username
    dataSource.password = postgres.password
    
    val adapter = JdbcSqlExecutor(dataSource)
    val dataService = PostgresDataServiceExecutor("default", adapter, dataSource)
    
    TeaQLManager.runtime = TeaQLRuntime.Builder()
        .metadata(metaFactory)
        .dataService("default", dataService)
        .build()
        
    TeaQLManager.customSink = customLogSink
    TeaQLManager.userContext = TeaQLManager.newContext()
    
    dataService.ensureSchema(TeaQLManager.userContext)
    
    // Seed basic data
    initDatabase()
    
    // Test Scenario 1: Fetch Products (Adding to cart depends on fetched products)
    println("\n--- SCENARIO 1: Fetch Products ---")
    val products = fetchProducts()
    println("Fetched ${products.size} products from DB.")
    assert(products.isNotEmpty()) { "Products should not be empty after initDatabase()" }
    
    // Test Scenario 2: Add to Cart & Checkout (creates order, transitions to PAID, creates items)
    println("\n--- SCENARIO 2: Add to Cart & Checkout ---")
    val cart = listOf(products[0], products[1])
    println("Simulating Add to Cart with: ${cart.map { it.name }}")
    checkoutCart(cart, "Credit Card")
    
    // Test Scenario 3: Order List
    println("\n--- SCENARIO 3: Order List ---")
    val dashboardData = fetchOrders()
    println("Total Orders: ${dashboardData.orders.size}")
    assert(dashboardData.orders.isNotEmpty()) { "Order list should not be empty" }
    
    val order = dashboardData.orders.first()
    println("Order ID: ${order.id}")
    println("Order Title: ${order.title}")
    println("Order Status: ${order.status?.name}")
    println("Order Total Amount: ${order.totalAmount}")
    assert(order.status?.code == "PAID") { "Order status should be PAID initially" }
    
    // Test Scenario 4: Order Status Transition
    println("\n--- SCENARIO 4: Order Status Transition (Dispensing -> Complete) ---")
    updateOrderStatus(order, "Dispense")
    
    val dashboardDataDispensing = fetchOrders()
    val orderDispensing = dashboardDataDispensing.orders.first()
    println("Order Status after dispense: ${orderDispensing.status?.name}")
    assert(orderDispensing.status?.code == "DISPENSING") { "Order status should be DISPENSING" }
    
    updateOrderStatus(orderDispensing, "Complete")
    
    val dashboardDataComplete = fetchOrders()
    val orderComplete = dashboardDataComplete.orders.first()
    println("Order Status after complete: ${orderComplete.status?.name}")
    assert(orderComplete.status?.code == "COMPLETED") { "Order status should be COMPLETED" }
    
    println("\nAll integration tests passed successfully!")
    postgres.stop()
}
