package com.example.mealzapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import com.example.mealzapp.navigation.NavigationComponent
import com.example.mealzapp.ui.theme.MealzAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    NavigationComponent(rememberNavController())
                }
            }
        }
    }
}
