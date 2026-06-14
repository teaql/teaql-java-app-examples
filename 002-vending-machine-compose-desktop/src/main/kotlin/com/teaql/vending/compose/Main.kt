package com.teaql.vending.compose

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

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
    Card(modifier = Modifier.fillMaxSize(), elevation = 2.dp) {
        Box(contentAlignment = Alignment.Center) {
            Text("欢迎光临选品大厅", fontSize = 24.sp, color = Color.Gray)
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
        Box(contentAlignment = Alignment.Center) {
            Text("系统实时运行日志", fontSize = 24.sp, color = Color.Gray)
        }
    }
}

fun main() = application {
    // TODO: Initialize TeaQL here
    // EntityMetaRegistry.registerAll()

    Window(onCloseRequest = ::exitApplication, title = "TeaQL Vending Machine Desktop",
        state = androidx.compose.ui.window.rememberWindowState(width = 1000.dp, height = 700.dp)) {
        App()
    }
}
