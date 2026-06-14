package com.teaql.vending.compose

import com.doublechaintech.vendingmachineservice.Q
import com.doublechaintech.vendingmachineservice.product.Product
import com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine
import com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder
import com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem
import com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment
import com.doublechaintech.vendingmachineservice.EntityMetaRegistry
import io.teaql.core.meta.SimpleEntityMetaFactory
import io.teaql.core.sqlite.SqliteDataServiceExecutor
import io.teaql.provider.jdbc.JdbcSqlExecutor
import io.teaql.runtime.TeaQLRuntime
import io.teaql.runtime.DefaultUserContext
import io.teaql.core.UserContext
import io.teaql.core.log.CustomLogSink

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.launch

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object TeaQLManager {
    lateinit var userContext: UserContext

    fun init(customLogSink: CustomLogSink) {
        val metaFactory = SimpleEntityMetaFactory()
        EntityMetaRegistry().assemble(metaFactory)
        io.teaql.core.meta.EntityMetaFactory.registerGlobal(metaFactory)
        
        val dataSource = org.sqlite.SQLiteDataSource()
        dataSource.url = "jdbc:sqlite:vending_world_cup.db"
        val adapter = io.teaql.provider.jdbc.JdbcSqlExecutor(dataSource)
        val dataService = SqliteDataServiceExecutor("default", adapter, dataSource)
        
        val runtime = TeaQLRuntime.Builder()
            .metadata(metaFactory)
            .dataService("default", dataService)
            .build()
            
        val ctx = DefaultUserContext(runtime)
        ctx.registerCustomSink(customLogSink)
        userContext = ctx
        
        dataService.ensureSchema(ctx)
    }
}

object SystemLogger {
    private val _logs = mutableStateListOf<String>()
    val logs: List<String> get() = _logs

    fun log(message: String) {
        val timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
        val finalMessage = "[$timestamp] $message"
        _logs.add(0, finalMessage)
        println(finalMessage)
    }
}

class GlobalLiveLogsSink : CustomLogSink {
    override fun onLog(formattedLogContent: String?) {
        if (formattedLogContent != null) {
            SystemLogger.log("[TeaQL Core] $formattedLogContent")
        }
    }
}

@Composable
@Preview
fun App() {
    var selectedTab by remember { mutableStateOf(0) }

    MaterialTheme(
        colors = lightColors(
            primary = Color(0xFF2196F3),
            primaryVariant = Color(0xFF1976D2),
            secondary = Color(0xFFFFC107)
        )
    ) {
        Row(modifier = Modifier.fillMaxSize().background(Color(0xFFF5F5F5))) {
            Column(
                modifier = Modifier
                    .width(200.dp)
                    .fillMaxHeight()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Vending Machine",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                NavItem("Purchase", Icons.Default.ShoppingCart, selectedTab == 0) { selectedTab = 0 }
                Spacer(modifier = Modifier.height(8.dp))
                NavItem("Admin", Icons.Default.Settings, selectedTab == 1) { selectedTab = 1 }
                Spacer(modifier = Modifier.height(8.dp))
                NavItem("Logs", Icons.Default.List, selectedTab == 2) { selectedTab = 2 }
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                when (selectedTab) {
                    0 -> PurchaseHallScreen()
                    1 -> AdminBackstageScreen()
                    2 -> SystemLogsScreen()
                }
            }
        }
    }
}

@Composable
fun NavItem(title: String, icon: ImageVector, isSelected: Boolean, onClick: () -> Unit) {
    val bgColor = if (isSelected) MaterialTheme.colors.primary.copy(alpha = 0.1f) else Color.Transparent
    val contentColor = if (isSelected) MaterialTheme.colors.primary else Color.Gray

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(bgColor, RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .padding(12.dp)
    ) {
        Icon(icon, contentDescription = title, tint = contentColor, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = title, color = contentColor, fontSize = 14.sp, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal)
    }
}

@Composable
fun PurchaseHallScreen() {
    var products by remember { mutableStateOf(emptyList<Product>()) }
    val cart = remember { mutableStateListOf<Product>() }
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        SystemLogger.log("Navigated to Purchase Hall.")
        withContext(Dispatchers.IO) {
            products = fetchProducts()
        }
    }

    Scaffold(scaffoldState = scaffoldState, backgroundColor = Color.Transparent) { padding ->
        if (products.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            Row(modifier = Modifier.fillMaxSize().padding(padding)) {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 200.dp),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.weight(2f)
                ) {
                    items(products) { product ->
                        ProductCard(product, onAddToCart = {
                            SystemLogger.log("Added to cart: ${product.name}")
                            cart.add(product)
                        })
                    }
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.White, RoundedCornerShape(8.dp))
                        .padding(16.dp)
                ) {
                    Text("Shopping Cart", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    val totalPrice = cart.sumOf { it.price }
                    
                    LazyColumn(modifier = Modifier.weight(1f)) {
                        items(cart) { item ->
                            Text("- ${item.name} ($${item.price})", fontSize = 14.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                        }
                    }
                    
                    Divider(modifier = Modifier.padding(vertical = 8.dp))
                    Text("Total: $$totalPrice", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Button(
                        onClick = {
                            if (cart.isNotEmpty()) {
                                SystemLogger.log("Initiating checkout for ${cart.size} items")
                                checkoutCart(cart)
                                cart.clear()
                                products = fetchProducts()
                                coroutineScope.launch {
                                    scaffoldState.snackbarHostState.showSnackbar("Checkout complete!")
                                }
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        enabled = cart.isNotEmpty()
                    ) {
                        Text("Checkout")
                    }
                }
            }
        }
    }
}

@Composable
fun ProductCard(product: Product, onAddToCart: () -> Unit) {
    Card(elevation = 4.dp, shape = RoundedCornerShape(8.dp), modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier.size(100.dp).background(Color.LightGray, RoundedCornerShape(8.dp)), contentAlignment = Alignment.Center) {
                Text(product.name.take(2), fontSize = 24.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(product.name, fontWeight = FontWeight.Bold, fontSize = 16.sp, maxLines = 1)
            Spacer(modifier = Modifier.height(8.dp))
            Text("$${product.price}", color = MaterialTheme.colors.secondary, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text("Stock: ${product.stock}", fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = onAddToCart, 
                modifier = Modifier.fillMaxWidth(),
                enabled = product.stock > 0
            ) {
                Text(if (product.stock > 0) "Add to Cart" else "Sold Out")
            }
        }
    }
}

@Composable
fun AdminBackstageScreen() {
    Card(modifier = Modifier.fillMaxSize(), elevation = 2.dp) {
        Box(contentAlignment = Alignment.Center) {
            Text("Admin Dashboard & Orders", fontSize = 24.sp, color = Color.Gray)
        }
    }
}

@Composable
fun SystemLogsScreen() {
    Card(modifier = Modifier.fillMaxSize(), elevation = 2.dp) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("System Operation Logs", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(SystemLogger.logs) { log ->
                    Text(log, modifier = Modifier.padding(vertical = 4.dp), fontFamily = FontFamily.Monospace, fontSize = 14.sp)
                    Divider(color = Color.LightGray, thickness = 0.5.dp)
                }
            }
        }
    }
}

fun initDatabase() {
    val ctx = TeaQLManager.userContext
    try {
        val count = Q.products().comment("init").purpose("check db").executeForList(ctx).size()
        if (count == 0) {
            val machine = VendingMachine.refer(1L)

            val seedData = listOf(
                arrayOf("Budweiser Beer", 15, 50, "https://example.com/bud.jpg"),
                arrayOf("Heineken", 18, 40, "https://example.com/hei.jpg"),
                arrayOf("Lays Chips", 8, 100, "https://example.com/lays.jpg"),
                arrayOf("Red Bull", 12, 60, "https://example.com/redbull.jpg"),
                arrayOf("Coca Cola", 5, 120, "https://example.com/cola.jpg"),
                arrayOf("Face Paint", 25, 30, "https://example.com/paint.jpg"),
                arrayOf("Mini Flag", 10, 200, "https://example.com/flag.jpg")
            )
            for (pData in seedData) {
                val p = Product()
                p.updateName(pData[0] as String)
                p.updatePrice(pData[1] as Int)
                p.updateStock(pData[2] as Int)
                p.updateImageUrl(pData[3] as String)
                p.updateVendingMachine(machine)
                p.auditAs<Product>("init product").save(ctx)
            }
            SystemLogger.log("Seed data initialized via TeaQL.")
        }
    } catch (e: Exception) {
        SystemLogger.log("Database initialization failed: ${e.message}")
        e.printStackTrace()
    }
}

fun fetchProducts(): List<Product> {
    val ctx = TeaQLManager.userContext
    return try {
        Q.products().comment("fetch").purpose("display products").executeForList(ctx).toList()
    } catch (e: Exception) {
        SystemLogger.log("Failed to fetch products: ${e.message}")
        e.printStackTrace()
        emptyList()
    }
}

fun checkoutCart(cart: List<Product>) {
    val ctx = TeaQLManager.userContext
    try {
        SystemLogger.log("Initiating TeaQL Checkout Transaction...")
        
        val order = VendingOrder()
        order.updateTitle("Order-" + System.currentTimeMillis())
        order.updateStatusToPaid()
        order.auditAs<VendingOrder>("create order").save(ctx)
        
        var totalAmount = 0
        for (product in cart) {
            val item = VendingOrderItem()
            item.updateName("Item-${product.name}")
            item.updateProduct(Product.refer(product.id.toLong()))
            item.updateQuantity(1)
            item.updatePrice(product.price)
            item.updateAmount(product.price)
            item.updateVendingOrder(order)
            item.auditAs<VendingOrderItem>("add item").save(ctx)
            
            val pDb = Q.products().withIdIs(product.id.toLong()).comment("fetch").purpose("stock check").executeForOne(ctx)
            if (pDb != null) {
                pDb.updateStock(pDb.stock - 1)
                if (pDb.stock < 0) throw Exception("Out of stock for ${pDb.name}!")
                pDb.auditAs<Product>("update stock").save(ctx)
            } else {
                throw Exception("Product not found: ${product.name}")
            }
            
            totalAmount += product.price
            SystemLogger.log("Added Order Item: ${product.name} (Amount: $${product.price})")
        }
        
        val payment = OrderPayment()
        payment.updateName("Payment-${order.title}")
        payment.updatePaymentMethodToCreditCard()
        payment.updateAmount(totalAmount)
        payment.updatePaymentStatusToSuccess()
        payment.updateVendingOrder(order)
        
        payment.auditAs<OrderPayment>("process payment").save(ctx)
        SystemLogger.log("Transaction committed successfully via TeaQL.")
    } catch (e: Exception) {
        SystemLogger.log("Transaction failed: ${e.message}")
        e.printStackTrace()
    }
}

fun main() = application {
    val customLogSink = GlobalLiveLogsSink()
    TeaQLManager.init(customLogSink)
    SystemLogger.log("Registered Global Live Logs Engine (CustomLogSink)")

    initDatabase()

    Window(onCloseRequest = ::exitApplication, title = "TeaQL Vending Machine Desktop",
        state = androidx.compose.ui.window.rememberWindowState(width = 1000.dp, height = 700.dp)) {
        App()
    }
}
