package com.example.mealzapp.ui.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealzapp.model.response.MealResponse
import com.example.mealzapp.network.MealsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MealsRepository
) : ViewModel() {

    val mealsState: MutableState<List<MealResponse>> = mutableStateOf(emptyList())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            mealsState.value = getMeals()
        }
    }

    private suspend fun getMeals() = repository.getMeals().categories

}