package com.example.cryptocurrency.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cryptocurrency.presentation.screens.SharedViewModel
import com.example.cryptocurrency.presentation.screens.coinDetails.CoinDetailsScreen
import com.example.cryptocurrency.presentation.screens.coinList.CoinListScreen

@Composable
fun NavigationComponent(navController: NavHostController) {

    val sharedViewModel: SharedViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.CoinListScreen.route) {
        composable(route = Screen.CoinListScreen.route) {
            CoinListScreen(
                onItemClick = { coin ->
                    sharedViewModel.currentCoin = coin
                    navController.navigate("${Screen.CoinDetailScreen.route}/${coin.id}")
                }
            )
        }
        composable(route = Screen.CoinDetailScreen.route + "/{coinId}") {
            val currentCoin = sharedViewModel.currentCoin!!
            CoinDetailsScreen(
                coin = currentCoin,
                backToPreviousScreenAction = { navController.popBackStack() }
            )
        }
    }
}