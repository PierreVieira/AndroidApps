package com.example.mealzapp.network

import com.example.mealzapp.model.response.MealsCategoriesResponse
import retrofit2.http.GET

interface MealsApi {

    companion object {
        const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    }

    @GET("categories.php")
    suspend fun getMeals(): MealsCategoriesResponse
}