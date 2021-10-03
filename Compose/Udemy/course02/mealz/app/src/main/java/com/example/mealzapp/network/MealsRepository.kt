package com.example.mealzapp.network

import com.example.mealzapp.model.response.MealResponse
import com.example.mealzapp.model.response.MealsCategoriesResponse
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class MealsRepository @Inject constructor(
    private val api: MealsApi
) {

    private var cachedMeals = listOf<MealResponse>()

    suspend fun getMeals(): MealsCategoriesResponse {
        val response = api.getMeals()
        cachedMeals = response.categories
        return response
    }

    fun getMeal(id: String) = cachedMeals.firstOrNull { it.id == id }
}