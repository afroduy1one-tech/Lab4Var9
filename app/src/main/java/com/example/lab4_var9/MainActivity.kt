package com.example.lab4_var9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab4_var9.ui.theme.Lab4_Var9Theme
import androidx.compose.foundation.layout.Column

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab4_Var9Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FactorialCheck()
                }
            }
        }
    }
}

@Composable
fun FactorialCheck() {
    Column {
        Text("Проверка факториала")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab4_Var9Theme {
        Greeting("Android")
    }
}