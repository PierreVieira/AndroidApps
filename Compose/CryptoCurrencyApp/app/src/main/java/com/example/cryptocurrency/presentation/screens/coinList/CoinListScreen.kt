package com.example.cryptocurrency.presentation.screens.coinList

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.presentation.screens.coinList.components.CoinListItem
import com.example.cryptocurrency.presentation.ui.components.CentralizedCircularProgressIndicator
import com.example.cryptocurrency.presentation.ui.components.ErrorConnectionComponent

@Composable
fun CoinListScreen(
    coinsListViewModel: CoinListViewModel = hiltViewModel(),
    onItemClick: (Coin) -> Unit,
) {
    val state = coinsListViewModel.state.value
    Scaffold {
        when {
            state.isLoading -> CentralizedCircularProgressIndicator()
            state.error.isNotBlank() -> ErrorConnectionComponent(
                reconnectAction = { coinsListViewModel.getCoins() },
                errorText = state.error
            )
            else -> CoinsList(state, onItemClick)
        }
    }
}

@Composable
private fun CoinsList(
    state: CoinListState,
    onItemClick: (Coin) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(state.coins) { coin ->
            CoinListItem(
                coin = coin,
                onItemClick = onItemClick
            )
        }
    }
}