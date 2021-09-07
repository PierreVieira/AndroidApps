package com.example.aula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aula.ui.theme.AulaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AulaTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ExibeTelaVertical()
                }
            }
        }
    }
}

@Composable
fun ExibeTelaHorizontal() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        Arrangement.Center
    ) {
        Text(text = "Olá mundo ")
        Text(text = "Aula 1 de compose")
    }
}

@Composable
fun ExibeTelaVertical() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 20.dp)
            .background(color = Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Olá mundo ",
            style = TextStyle(
                color = Color.Blue,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(text = "Aula 1 de compose")
        Text(text = "Olá mundo ")
        Text(text = "Aula 1 de compose")
        Text(text = "Olá mundo ")
        Text(text = "Aula 1 de compose")
        ExibeTelaHorizontal()
    }
}
