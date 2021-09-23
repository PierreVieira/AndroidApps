package com.example.cryptocurrency.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import com.example.cryptocurrency.presentation.navigation.NavigationComponent
import com.example.cryptocurrency.presentation.ui.theme.CryptoCurrenciesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoCurrenciesTheme {
                Surface(color = MaterialTheme.colors.background) {
                    NavigationComponent(rememberNavController())
                }
            }
        }
    }
}