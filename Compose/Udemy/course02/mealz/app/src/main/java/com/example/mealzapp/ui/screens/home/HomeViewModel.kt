package com.example.mealzapp.ui.screens.home

import androidx.lifecycle.ViewModel
import com.example.mealzapp.repository.MealsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MealsRepository
) : ViewModel() {

}