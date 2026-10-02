package com.example.lab4_var9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FactorialCheck()
        }
    }
}

@Composable
fun FactorialCheck() {
    var n by remember { mutableStateOf("") }
    var factorial by remember { mutableLongStateOf(1L) }

    Column {
        Text("Проверка факториала")

        OutlinedTextField(
            value = n,
            onValueChange = { n = it },
            label = { Text("Введите n") }
        )

        Button(
            onClick = {
                factorial = 1L

                for (i in 1..n.toInt()) {
                    factorial *= i
                }
            }
        )
        {
            Text("Посчитать")
        }
        Text("Факториал: $factorial")
    }
}

@Preview(showBackground = true)
@Composable
fun FactorialCheckPreview() {
    FactorialCheck()
}
