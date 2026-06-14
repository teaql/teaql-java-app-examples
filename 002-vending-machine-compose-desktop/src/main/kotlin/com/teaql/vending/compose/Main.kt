package com.teaql.vending.compose

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Welcome to Vending Machine!") }
    var count by remember { mutableStateOf(0) }

    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text)
            Spacer(Modifier.height(16.dp))
            Button(onClick = {
                count++
                text = "Dispensed Item! (Total: $count)"
            }) {
                Text("Buy Now")
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "TeaQL Vending Machine (Compose)") {
        App()
    }
}
