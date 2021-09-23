package com.example.cryptocurrency.presentation.screens.coinDetails.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cryptocurrency.domain.model.CoinDetail
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun TagsRow(coin: CoinDetail) {
    FlowRow(
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 8.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        coin.tags.forEach { tag ->
            CoinTag(tag = tag)
        }
    }
}