package com.teaql.vending.compose

import com.doublechaintech.vendingmachineservice.Q
import io.teaql.core.meta.SimpleEntityMetaFactory
import io.teaql.provider.jdbc.JdbcSqlExecutor
import io.teaql.runtime.TeaQLRuntime
import org.postgresql.ds.PGSimpleDataSource
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import io.teaql.core.postgres.PostgresDataServiceExecutor

class IntegrationTest {

    companion object {
        @JvmStatic
        @BeforeAll
        fun setupDatabase() {
            println("Connecting to local PostgreSQL...")
            val jdbcUrl = "jdbc:postgresql://localhost:5432/postgres"
            val user = "postgres"
            val passwordsToTry = listOf("postgres", "password", "", "root", "123456", "admin")

            println("Initializing TeaQLManager with PostgreSQL...")
            val customLogSink = GlobalLiveLogsSink()
            
            val metaFactory = SimpleEntityMetaFactory()
            com.doublechaintech.vendingmachineservice.EntityMetaRegistry().assemble(metaFactory)
            io.teaql.core.meta.EntityMetaFactory.registerGlobal(metaFactory)
            
            var connected = false
            var workingPassword = ""
            for (pwd in passwordsToTry) {
                try {
                    java.sql.DriverManager.getConnection(jdbcUrl, user, pwd).use { conn ->
                        connected = true
                        workingPassword = pwd
                    }
                    break
                } catch (e: Exception) {
                    // ignore
                }
            }
            if (!connected) throw RuntimeException("Could not connect to PostgreSQL with any common password")
            
            val dataSource = PGSimpleDataSource()
            dataSource.setUrl(jdbcUrl)
            dataSource.user = user
            dataSource.password = workingPassword
            
            val adapter = JdbcSqlExecutor(dataSource)
            val dataService = PostgresDataServiceExecutor("default", adapter)
            
            TeaQLManager.runtime = TeaQLRuntime.Builder()
                .metadata(metaFactory)
                .dataService("default", dataService)
                .build()
                
            TeaQLManager.customSink = customLogSink
            TeaQLManager.userContext = TeaQLManager.newContext()
            
            dataService.ensureSchema(TeaQLManager.userContext)
            
            // Seed basic data
            initDatabase()
        }
    }

    @Test
    fun testIntegrationScenarios() {
        // Test Scenario 1: Fetch Products
        println("\n--- SCENARIO 1: Fetch Products ---")
        val products = fetchProducts()
        println("Fetched ${products.size} products from DB.")
        assertTrue(products.isNotEmpty(), "Products should not be empty after initDatabase()")
        
        // Test Scenario 2: Add to Cart & Checkout (creates order, transitions to PAID, creates items)
        println("\n--- SCENARIO 2: Add to Cart & Checkout ---")
        val cart = listOf(products[0], products[1])
        println("Simulating Add to Cart with: ${cart.map { it.name }}")
        checkoutCart(cart, "Credit Card")
        
        // Test Scenario 3: Order List
        println("\n--- SCENARIO 3: Order List ---")
        val dashboardData = fetchOrders()
        println("Total Orders: ${dashboardData.orders.size}")
        assertTrue(dashboardData.orders.isNotEmpty(), "Order list should not be empty")
        
        val order = dashboardData.orders.sortedByDescending { it.id }.first()
        println("Order ID: ${order.id}")
        println("Order Title: ${order.title}")
        println("Order Status: ${order.status?.name}")
        println("Order Total Amount: ${order.totalAmount}")
        assertEquals("PAID", order.status?.code, "Order status should be PAID initially")
        
        // Test Scenario 4: Order Status Transition
        println("\n--- SCENARIO 4: Order Status Transition (Dispensing -> Complete) ---")
        updateOrderStatus(order, "Dispense")
        
        val dashboardDataDispensing = fetchOrders()
        val orderDispensing = dashboardDataDispensing.orders.find { it.id == order.id }!!
        println("Order Status after dispense: ${orderDispensing.status?.name}")
        assertEquals("DISPENSING", orderDispensing.status?.code, "Order status should be DISPENSING")
        
        updateOrderStatus(orderDispensing, "Complete")
        
        val dashboardDataComplete = fetchOrders()
        val orderComplete = dashboardDataComplete.orders.find { it.id == order.id }!!
        println("Order Status after complete: ${orderComplete.status?.name}")
        assertEquals("COMPLETED", orderComplete.status?.code, "Order status should be COMPLETED")
        
        println("\nAll integration tests passed successfully!")
    }
}
