package com.example.cryptocurrency.presentation.screens.coinDetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrency.common.Constants
import com.example.cryptocurrency.common.Resource
import com.example.cryptocurrency.domain.useCase.getCoin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoinDetails(coinId)
        }
    }

    fun getCoinDetails(id: String) {
        getCoinUseCase(id).onEach { result ->
            _state.value = when (result) {
                is Resource.Success -> CoinDetailState(coin = result.data)
                is Resource.Error -> CoinDetailState(
                    error = result.message ?: "An unexpected error occurred."
                )
                is Resource.Loading -> CoinDetailState(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }
}