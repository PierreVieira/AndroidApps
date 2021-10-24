package com.example.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val colorState = remember {
                mutableStateOf(Color.Yellow)
            }
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                ColorBox(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize(),
                    updateColor = {
                        colorState.value = randomColor()
                    }
                )
                Box(
                    modifier = Modifier
                        .background(
                            color = colorState.value
                        )
                        .weight(1f)
                        .fillMaxSize()
                ) {

                }
            }
        }
    }
}

@Composable
private fun ColorBox(updateColor: () -> Unit, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                color = Color.Green
            )
            .clickable {
                updateColor()
            }
    )
}

private fun randomColor() = Color(
    red = Random.nextFloat(),
    green = Random.nextFloat(),
    blue = Random.nextFloat(),
    alpha = 1f
)