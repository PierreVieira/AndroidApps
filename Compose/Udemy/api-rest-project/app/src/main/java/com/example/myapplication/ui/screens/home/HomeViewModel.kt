package com.example.myapplication.ui.screens.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.network.api.DigimonRepository
import com.example.myapplication.network.response.Digimon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: DigimonRepository) : ViewModel() {
    val digimonList = mutableStateOf<List<Digimon>>(listOf())

    init {
        loadDigimons()
    }

    private fun loadDigimons() {
        viewModelScope.launch {
            digimonList.value = repository.getDigimonList()
        }
    }
}