package com.example.mealzapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mealzapp.ui.screens.details.DetailsScreen
import com.example.mealzapp.ui.screens.home.HomeScreen

@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.Home.value) {
        composable(Routes.Home.value) {
            HomeScreen(
                navToDetailsAction = { id ->
                    navController.navigate(Routes.Details.getDynamicRoute(id))
                }
            )
        }
        composable(
            route = Routes.Details.value,
            arguments = listOf(navArgument(Routes.FOOD_ID) { type = NavType.StringType })
        ) {
            DetailsScreen()
        }
    }
}