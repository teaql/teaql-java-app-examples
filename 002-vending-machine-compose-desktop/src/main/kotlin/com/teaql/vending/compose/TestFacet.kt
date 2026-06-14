package com.teaql.vending.compose

import com.doublechaintech.vendingmachineservice.Q

fun main() {
    SystemLogger.log("Starting TestFacet...")
    try {
        TeaQLManager.init { msg -> SystemLogger.log(msg) }
        val ctx = TeaQLManager.userContext
        
        SystemLogger.log("Executing facet query...")
        val ordersSmartList = Q.vendingOrders()
            .facetByStatusAs("order_status", Q.orderStatuses().selectSelf(), true)
            .selectStatus()
            .comment("fetch").purpose("test").executeForList(ctx)
            
        val counts = mutableMapOf<String, Int>()
        val facets = ordersSmartList.getFacets()
        if (facets != null) {
            val statusFacetList = facets.get("order_status")
            if (statusFacetList != null) {
                for (item in statusFacetList) {
                    try {
                        val count = (item as io.teaql.core.BaseEntity).getDynamicProperty<Int>("count") ?: 0
                        val name = item.javaClass.getMethod("getName").invoke(item) as String
                        counts[name] = count
                        SystemLogger.log("Facet Item: name=\$name, count=\$count")
                    } catch (e: Exception) {
                        SystemLogger.log("Error extracting facet item: \${e.message}")
                        e.printStackTrace()
                    }
                }
            } else {
                SystemLogger.log("order_status facet list is null!")
            }
        } else {
            SystemLogger.log("facets map is null!")
        }
        
        SystemLogger.log("DEBUG: Facet aggregated \${counts.size} status types.")
        SystemLogger.log("Final Counts: \$counts")
        
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
