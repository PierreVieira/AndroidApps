package com.example.cryptocurrency.presentation.screens.coinDetails.components.texts

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun CoinDescriptionText(description: String) {
    Text(
        text = description,
        style = MaterialTheme.typography.body2
    )
}