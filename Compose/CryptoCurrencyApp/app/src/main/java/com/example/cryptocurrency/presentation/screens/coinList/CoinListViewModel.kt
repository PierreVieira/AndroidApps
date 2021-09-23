package com.example.cryptocurrency.presentation.screens.coinList

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrency.common.Resource
import com.example.cryptocurrency.domain.useCase.getCoins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    fun getCoins() {
        getCoinsUseCase().onEach { result ->
            _state.value = when (result) {
                is Resource.Success -> CoinListState(coins = result.data ?: emptyList())
                is Resource.Error -> CoinListState(
                    error = result.message ?: "An unexpected error occurred."
                )
                is Resource.Loading -> CoinListState(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }
}