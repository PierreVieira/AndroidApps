package com.example.mealzapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mealzapp.ui.screens.home.HomeScreen

@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.Home.value) {
        composable(Routes.Home.value) {
            HomeScreen()
        }
    }
}