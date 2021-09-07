package com.example.crud.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.example.crud.ui.screens.crud.details.DetailScreen
import com.example.crud.ui.screens.crud.register.RegisterScreen
import com.example.crud.ui.screens.home.HomeScreen
import com.example.crud.ui.screens.home.HomeViewModel

@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            val homeViewModel: HomeViewModel = hiltViewModel()
            val cities = homeViewModel.cities.observeAsState(listOf())
            HomeScreen(
                cities = cities,
                navigateToDetailsAction = { navController.navigate(Routes.REGISTER) }
            ) { cityId ->
                navController.navigate(Routes.getDetailsDynamicRoute(cityId))
            }
        }
        composable(Routes.REGISTER) { RegisterScreen { navController.popBackStack() } }
        composable(
            route = Routes.DETAILS,
            arguments = listOf(navArgument(Routes.CITY_ID_KEY) { type = NavType.IntType })
        ) { backStackEntry ->
            val cityId = backStackEntry.arguments?.getInt(Routes.CITY_ID_KEY)
            cityId?.let {
                DetailScreen(cityId = it, popNavigation = { navController.popBackStack() })
            }
        }
    }
}