package com.example.profilecard.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.profilecard.model.userList
import com.example.profilecard.ui.screens.details.DetailsScreen
import com.example.profilecard.ui.screens.home.HomeScreen

@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.Home.value) {
        composable(Routes.Home.value) {
            HomeScreen(
                openDetailsAction = { user ->
                    navController.navigate(Routes.Details.getDynamicRoute(user.id))
                }
            )
        }
        composable(
            route = Routes.Details.value,
            arguments = listOf(
                navArgument(Routes.USER_ID) { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString(Routes.USER_ID)
            val user = userList.first { it.id == userId }
            DetailsScreen(user = user, backAction = { navController.popBackStack() })
        }
    }
}