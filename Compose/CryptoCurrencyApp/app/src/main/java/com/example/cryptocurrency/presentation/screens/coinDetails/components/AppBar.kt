package com.example.cryptocurrency.presentation.screens.coinDetails.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.presentation.ui.theme.CryptoCurrenciesTheme

@Composable
fun DetailsAppBar(coin: Coin, backAction: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { backAction() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        },
        title = { Text(text = "${coin.rank}. ${coin.name} (${coin.symbol})") }
    )
}

@Composable
@Preview
fun DetailsAppBarPreview() {
    val bitcoin = Coin(
        id = "",
        isActive = true,
        name = "Bitcoin",
        rank = 1,
        symbol = "BTC"
    )
    CryptoCurrenciesTheme {
        DetailsAppBar(coin = bitcoin, backAction = {})
    }
}