package com.example.mealzapp.ui.screens.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mealzapp.model.response.MealResponse
import com.example.mealzapp.navigation.Routes
import com.example.mealzapp.network.MealsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    repository: MealsRepository
) : ViewModel() {
    var mealState = mutableStateOf<MealResponse?>(null)

    init {
        val mealId = savedStateHandle.get<String>(Routes.FOOD_ID) ?: ""
        mealState.value = repository.getMeal(mealId)
    }
}