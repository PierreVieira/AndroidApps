package com.example.cryptocurrency.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cryptocurrency.presentation.screens.coinDetails.CoinDetailScreen
import com.example.cryptocurrency.presentation.screens.coinDetails.CoinDetailsViewModel
import com.example.cryptocurrency.presentation.screens.coinList.CoinListScreen
import com.example.cryptocurrency.presentation.screens.coinList.CoinListViewModel

@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.CoinListScreen.route) {
        composable(route = Screen.CoinListScreen.route) {
            val coinsListViewModel: CoinListViewModel = hiltViewModel()
            val state = coinsListViewModel.state.value
            CoinListScreen(
                state = state,
                onItemClick = {
                    navController.navigate("${Screen.CoinDetailScreen.route}/${it.id}")
                }
            )
        }
        composable(route = Screen.CoinDetailScreen.route + "/{coinId}") {
            val coinDetailsViewModel: CoinDetailsViewModel = hiltViewModel()
            val state = coinDetailsViewModel.state.value
            CoinDetailScreen(state)
        }
    }
}