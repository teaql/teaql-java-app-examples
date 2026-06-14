package com.teaql.vending.compose

import com.doublechaintech.vendingmachineservice.Q
import com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder

fun main() {
    println("Initializing TeaQLManager...")
    val customLogSink = GlobalLiveLogsSink()
    TeaQLManager.init(customLogSink)
    initDatabase()
    
    // Add a dummy order to test relation mapping
    val dummyOrder = VendingOrder()
    dummyOrder.updateTitle("Test Order 1")
    dummyOrder.updateStatusToPaid()
    dummyOrder.auditAs<VendingOrder>("create order").save(TeaQLManager.userContext)
    
    println("Running fetchOrders()...")
    val dashboardData = fetchOrders()
    
    println("Orders count: ${dashboardData.orders.size}")
    for (order in dashboardData.orders) {
        println("Order ID: ${order.id}")
        println("Order Title: ${order.title}")
        println("Order Status Name: ${order.status?.name ?: "NULL"}")
        println("Order Status Code: ${order.status?.code ?: "NULL"}")
        println("---")
    }
    
    println("Facets:")
    for ((name, count) in dashboardData.statusCounts) {
        println("$name: $count")
    }
}
