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
    
    val ctx = TeaQLManager.userContext
    
    val p = com.doublechaintech.vendingmachineservice.product.Product()
    p.updateName("Sample Product")
    p.updateImageUrl("https://example.com/img.png")
    p.auditAs<com.doublechaintech.vendingmachineservice.product.Product>("create product").save(ctx)

    for (i in 0 until 4) {
        val item = com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem()
        item.updateName("Test Item $i")
        item.updateVendingOrder(dummyOrder)
        item.updateProduct(p)
        item.auditAs<com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem>("add item").save(ctx)
    }
    
    println("Running fetchOrders()...")
    val dashboardData = fetchOrders()
    
    println("Orders count: ${dashboardData.orders.size}")
    for (order in dashboardData.orders) {
        println("Order ID: ${order.id}")
        println("Order Title: ${order.title}")
        println("Order Status Name: ${order.status?.name ?: "NULL"}")
        println("Order Status Code: ${order.status?.code ?: "NULL"}")
        
        val items = order.vendingOrderItemList
        println("Items count: ${items?.size() ?: 0}")
        println("Total items count from SmartList: ${items?.totalCount ?: 0}")
        if (items != null) {
            for (item in items) {
                println(" - Item: ${item.name}, Product: ${item.product?.name}, Image: ${item.product?.imageUrl}")
            }
        }
        println("---")
    }
    
    println("Facets:")
    for ((name, count) in dashboardData.statusCounts) {
        println("$name: $count")
    }
}
