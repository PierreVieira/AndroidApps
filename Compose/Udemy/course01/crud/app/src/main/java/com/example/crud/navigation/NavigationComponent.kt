package com.example.crud.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.crud.ui.screens.crud.details.DetailScreen
import com.example.crud.ui.screens.crud.register.RegisterScreen
import com.example.crud.ui.screens.home.HomeScreen
import com.example.crud.ui.screens.home.HomeViewModel

@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.Home.value) {
        composable(Routes.Home.value) {
            val homeViewModel: HomeViewModel = hiltViewModel()
            val cities = homeViewModel.cities.observeAsState(listOf())
            HomeScreen(
                cities = cities,
                navigateToDetailsAction = { navController.navigate(Routes.Register.value) },
                openCardDetailsAction = { cityId ->
                    navController.navigate(
                        Routes.Details.getDynamicRoute(cityId)
                    )
                }
            )
        }
        composable(Routes.Register.value) { RegisterScreen { navController.popBackStack() } }
        composable(
            route = Routes.Details.value,
            arguments = listOf(
                navArgument(Routes.CITY_ID) { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val cityId = backStackEntry.arguments?.getInt(Routes.CITY_ID)
            cityId?.let {
                DetailScreen(cityId = it, popNavigation = { navController.popBackStack() })
            }
        }
    }
}