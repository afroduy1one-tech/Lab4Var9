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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
    var k = 1L
    var isPossible by remember { mutableStateOf(false) }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Проверка факториала")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = n,
            onValueChange = { n = it },
            label = { Text("Введите n") }
        )

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {
                factorial = 1L

                for (i in 1..n.toInt()) {
                    factorial *= i
                }

                isPossible = false
                k = 1L

                while (k * (k + 1) * (k + 2) <= factorial) {
                    if (k * (k + 1) * (k + 2) == factorial) {
                        isPossible = true
                        break
                    }

                    k++
                }

                result = if (isPossible) {
                    "Можно представить $factorial в виде произведения трех последовательных чисел"
                } else {
                    "Нельзя представить $factorial в виде произведения трех последовательных чисел"
                }
            }
        ) {
            Text("Посчитать")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (result.isNotEmpty()) {
            Text(result)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FactorialCheckPreview() {
    FactorialCheck()
}
