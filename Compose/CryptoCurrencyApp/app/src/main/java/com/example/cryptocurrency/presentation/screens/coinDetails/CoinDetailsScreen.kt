package com.example.cryptocurrency.presentation.screens.coinDetails

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.domain.model.CoinDetail
import com.example.cryptocurrency.presentation.screens.coinDetails.components.DetailsAppBar
import com.example.cryptocurrency.presentation.screens.coinDetails.components.TagsRow
import com.example.cryptocurrency.presentation.screens.coinDetails.components.TeamListItem
import com.example.cryptocurrency.presentation.screens.coinDetails.components.texts.CoinDescriptionText
import com.example.cryptocurrency.presentation.screens.coinDetails.components.texts.TagsText
import com.example.cryptocurrency.presentation.screens.coinDetails.components.texts.TeamMembersText
import com.example.cryptocurrency.presentation.ui.components.CentralizedCircularProgressIndicator
import com.example.cryptocurrency.presentation.ui.components.ErrorConnectionComponent

@Composable
fun CoinDetailsScreen(
    coin: Coin,
    viewModel: CoinDetailsViewModel = hiltViewModel(),
    backToPreviousScreenAction: () -> Unit
) {
    val state = viewModel.state.value
    Scaffold(
        topBar = {
            DetailsAppBar(
                coin = coin,
                backAction = backToPreviousScreenAction
            )
        }
    ) {
        when {
            state.isLoading -> CentralizedCircularProgressIndicator()
            state.error.isNotBlank() -> ErrorConnectionComponent(
                reconnectAction = { viewModel.getCoinDetails(coin.id) },
                errorText = state.error
            )
            else -> CoinDetailsLoaded(state)
        }
    }
}


@Composable
private fun CoinDetailsLoaded(state: CoinDetailState) {
    state.coin?.let {
        ListDetails(it)
    }
}

@Composable
private fun ListDetails(coin: CoinDetail) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            CoinDescriptionText(coin.description)
            Spacer(modifier = Modifier.height(16.dp))
            TagsText()
            Spacer(modifier = Modifier.height(16.dp))
            TagsRow(coin)
            Spacer(modifier = Modifier.height(16.dp))
            TeamMembersText()
            Spacer(modifier = Modifier.height(16.dp))
        }
        items(coin.team) { teamMember ->
            TeamListItem(
                teamMember = teamMember,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Divider()
        }
    }
}
