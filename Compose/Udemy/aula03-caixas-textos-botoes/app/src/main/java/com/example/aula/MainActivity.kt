package com.example.aula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.aula.ui.theme.AulaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AulaTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    InitialScreen()
                }
            }
        }
    }
}

@Composable
fun InitialScreen() {
    var firstValue by remember {
        mutableStateOf("")
    }
    var secondValue by remember {
        mutableStateOf("")
    }
    var result by remember {
        mutableStateOf("undefined")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EditValueField(firstValue, "primeiro") { firstValue = it }
        Spacer(modifier = Modifier.height(16.dp))
        EditValueField(secondValue, "segundo") { secondValue = it }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val value = firstValue.toDouble() + secondValue.toDouble()
                result = value.toString()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {
            Text(text = "SOMAR")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Resultado: $result")
    }
}

@Composable
private fun EditValueField(value: String, type: String, onValueChanged: (String) -> Unit) {
    OutlinedTextField(
        label = { Text(text = "Digite o $type valor") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        value = value,
        onValueChange = onValueChanged
    )
}
