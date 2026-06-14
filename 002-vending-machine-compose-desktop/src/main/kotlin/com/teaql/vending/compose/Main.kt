package com.teaql.vending.compose

import com.doublechaintech.vendingmachineservice.product.Product
import com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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
import io.teaql.core.log.CustomLogSink

object SystemLogger {
    val logs = mutableStateListOf<String>()

    fun log(message: String) {
        val timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
        logs.add(0, "[$timestamp] $message")
        println("[$timestamp] $message")
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
            // Sidebar Navigation
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

                NavItem("选品大厅 (Purchase)", Icons.Default.ShoppingCart, selectedTab == 0) { selectedTab = 0 }
                Spacer(modifier = Modifier.height(8.dp))
                NavItem("后台管理 (Admin)", Icons.Default.Settings, selectedTab == 1) { selectedTab = 1 }
                Spacer(modifier = Modifier.height(8.dp))
                NavItem("运行日志 (Logs)", Icons.Default.List, selectedTab == 2) { selectedTab = 2 }
            }

            // Main Content Area
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

    LaunchedEffect(Unit) {
        SystemLogger.log("Navigated to Purchase Hall.")
        withContext(Dispatchers.IO) {
            products = fetchProducts()
        }
    }

    if (products.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 200.dp),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(products) { product ->
                ProductCard(product, onPurchase = {
                    SystemLogger.log("Initiating purchase for ${product.name}")
                    purchaseProduct(product)
                    SystemLogger.log("Purchase complete. Reloading products...")
                    // Reload
                    products = fetchProducts()
                })
            }
        }
    }
}

@Composable
fun ProductCard(product: Product, onPurchase: () -> Unit) {
    Card(elevation = 4.dp, shape = RoundedCornerShape(8.dp), modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier.size(100.dp).background(Color.LightGray, RoundedCornerShape(8.dp)), contentAlignment = Alignment.Center) {
                Text(product.name.take(2), fontSize = 24.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(product.name, fontWeight = FontWeight.Bold, fontSize = 16.sp, maxLines = 1)
            Spacer(modifier = Modifier.height(8.dp))
            Text("¥${product.price}", color = MaterialTheme.colors.secondary, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = onPurchase, 
                modifier = Modifier.fillMaxWidth(),
                enabled = product.stock > 0
            ) {
                Text(if (product.stock > 0) "购买 (Buy)" else "售罄 (Sold Out)")
            }
        }
    }
}

@Composable
fun AdminBackstageScreen() {
    Card(modifier = Modifier.fillMaxSize(), elevation = 2.dp) {
        Box(contentAlignment = Alignment.Center) {
            Text("后台商品及订单管理", fontSize = 24.sp, color = Color.Gray)
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
    val connection = java.sql.DriverManager.getConnection("jdbc:sqlite:vending_world_cup.db")
    connection.createStatement().use { stmt ->
        stmt.execute("""
            CREATE TABLE IF NOT EXISTS vending_machine_data (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name VARCHAR(100),
                create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                version INTEGER DEFAULT 1
            )
        """)
        stmt.execute("""
            CREATE TABLE IF NOT EXISTS product_data (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name VARCHAR(100),
                price INTEGER,
                stock INTEGER,
                image_url VARCHAR(100),
                vending_machine INTEGER,
                create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                version INTEGER DEFAULT 1
            )
        """)
        stmt.execute("""
            CREATE TABLE IF NOT EXISTS vending_order_data (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name VARCHAR(100),
                vending_machine INTEGER,
                create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                version INTEGER DEFAULT 1
            )
        """)
        stmt.execute("""
            CREATE TABLE IF NOT EXISTS vending_order_item_data (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name VARCHAR(100),
                vending_order INTEGER,
                product INTEGER,
                quantity INTEGER,
                amount INTEGER,
                create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                version INTEGER DEFAULT 1
            )
        """)
        stmt.execute("""
            CREATE TABLE IF NOT EXISTS order_payment_data (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name VARCHAR(100),
                vending_order INTEGER,
                payment_method VARCHAR(50),
                amount INTEGER,
                payment_status VARCHAR(50),
                create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                version INTEGER DEFAULT 1
            )
        """)
        
        val rs = stmt.executeQuery("SELECT count(*) FROM product_data")
        rs.next()
        if (rs.getInt(1) == 0) {
            stmt.execute("INSERT INTO vending_machine_data (name, version) VALUES ('World Cup Vending Machine', 1)")
            val insertProduct = "INSERT INTO product_data (name, price, stock, image_url, vending_machine, version) VALUES (?, ?, ?, ?, 1, 1)"
            val pstmt = connection.prepareStatement(insertProduct)
            
            val products = listOf(
                arrayOf("Budweiser Beer (百威)", 15, 50, "https://example.com/bud.jpg"),
                arrayOf("Heineken (喜力)", 18, 40, "https://example.com/hei.jpg"),
                arrayOf("Lays Chips (乐事)", 8, 100, "https://example.com/lays.jpg"),
                arrayOf("Red Bull (红牛)", 12, 60, "https://example.com/redbull.jpg"),
                arrayOf("Coca Cola (可乐)", 5, 120, "https://example.com/cola.jpg"),
                arrayOf("Face Paint (彩绘)", 25, 30, "https://example.com/paint.jpg"),
                arrayOf("Mini Flag (国旗)", 10, 200, "https://example.com/flag.jpg")
            )
            for (p in products) {
                pstmt.setString(1, p[0] as String)
                pstmt.setInt(2, p[1] as Int)
                pstmt.setInt(3, p[2] as Int)
                pstmt.setString(4, p[3] as String)
                pstmt.addBatch()
            }
            pstmt.executeBatch()
            println("Initialized World Cup Products in Database!")
        }
    }
    connection.close()
}

fun fetchProducts(): List<Product> {
    val list = mutableListOf<Product>()
    val connection = java.sql.DriverManager.getConnection("jdbc:sqlite:vending_world_cup.db")
    connection.createStatement().use { stmt ->
        val rs = stmt.executeQuery("SELECT * FROM product_data")
        while (rs.next()) {
            val p = Product()
            p.internalSet("id", rs.getLong("id"))
            p.updateName(rs.getString("name"))
            p.updatePrice(rs.getInt("price"))
            p.updateStock(rs.getInt("stock"))
            p.updateImageUrl(rs.getString("image_url"))
            list.add(p)
        }
    }
    connection.close()
    return list
}

fun purchaseProduct(product: Product) {
    val connection = java.sql.DriverManager.getConnection("jdbc:sqlite:vending_world_cup.db")
    connection.autoCommit = false
    try {
        // 1. Create Vending Order
        val insertOrder = connection.prepareStatement("INSERT INTO vending_order_data (name, vending_machine, version) VALUES (?, 1, 1)", java.sql.Statement.RETURN_GENERATED_KEYS)
        val orderName = "Order-" + System.currentTimeMillis()
        insertOrder.setString(1, orderName)
        insertOrder.executeUpdate()
        val orderKeys = insertOrder.generatedKeys
        orderKeys.next()
        val orderId = orderKeys.getLong(1)
        SystemLogger.log("Created Vending Order ID=$orderId ($orderName)")

        // 2. Create Vending Order Item
        val insertItem = connection.prepareStatement("INSERT INTO vending_order_item_data (name, vending_order, product, quantity, amount, version) VALUES (?, ?, ?, 1, ?, 1)")
        insertItem.setString(1, "Item-${product.name}")
        insertItem.setLong(2, orderId)
        insertItem.setLong(3, product.id ?: 0L)
        insertItem.setInt(4, product.price)
        insertItem.executeUpdate()
        SystemLogger.log("Added Order Item: ${product.name} (Amount: ¥${product.price})")

        // 3. Create Order Payment (Using US Payment Methods)
        val paymentMethods = listOf("Google Pay", "Apple Pay", "Credit Card")
        val chosenMethod = paymentMethods.random()
        val insertPayment = connection.prepareStatement("INSERT INTO order_payment_data (name, vending_order, payment_method, amount, payment_status, version) VALUES (?, ?, ?, ?, 'PAID', 1)")
        insertPayment.setString(1, "Payment-$orderName")
        insertPayment.setLong(2, orderId)
        insertPayment.setString(3, chosenMethod)
        insertPayment.setInt(4, product.price)
        insertPayment.executeUpdate()
        SystemLogger.log("Processed Payment of ¥${product.price} via $chosenMethod [Status: PAID]")

        // 4. Update Product Stock
        val updateStock = connection.prepareStatement("UPDATE product_data SET stock = stock - 1 WHERE id = ? AND stock > 0")
        updateStock.setLong(1, product.id ?: 0L)
        val rows = updateStock.executeUpdate()
        if (rows == 0) {
            throw Exception("Out of stock!")
        }
        SystemLogger.log("Deducted stock for ${product.name}.")

        connection.commit()
        SystemLogger.log("Transaction committed successfully.")
    } catch (e: Exception) {
        connection.rollback()
        SystemLogger.log("Transaction failed: ${e.message}")
    } finally {
        connection.close()
    }
}

fun main() = application {
    initDatabase()

    val customLogSink = GlobalLiveLogsSink()
    SystemLogger.log("Registered Global Live Logs Engine (CustomLogSink)")

    Window(onCloseRequest = ::exitApplication, title = "TeaQL Vending Machine Desktop",
        state = androidx.compose.ui.window.rememberWindowState(width = 1000.dp, height = 700.dp)) {
        App()
    }
}
