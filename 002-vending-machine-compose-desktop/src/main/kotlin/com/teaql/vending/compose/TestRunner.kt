package com.teaql.vending.compose

import com.doublechaintech.vendingmachineservice.product.Product

fun main() {
    val customLogSink = GlobalLiveLogsSink()
    TeaQLManager.init(customLogSink)

    initDatabase() // Ensure tables are created

    println("Fetching products...")
    val products = fetchProducts()
    println("Fetched ${products.size} products.")
    for (product in products) {
        println(" - ${product.name} (Stock: ${product.stock})")
    }

    val p = Product()
    p.updateName("Test Product")
    p.auditAs<Product>("test save").save(TeaQLManager.userContext)
    println("Saved new product: ${p.id}")
}
