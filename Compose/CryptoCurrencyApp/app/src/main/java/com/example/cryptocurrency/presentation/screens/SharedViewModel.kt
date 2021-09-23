package com.example.cryptocurrency.presentation.screens

import androidx.lifecycle.ViewModel
import com.example.cryptocurrency.domain.model.Coin

class SharedViewModel : ViewModel() {
    var currentCoin: Coin? = null
}