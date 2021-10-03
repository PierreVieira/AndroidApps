package com.example.mealzapp.navigation

sealed class Routes(val value: String) {

    companion object {
        private const val DETAILS_BASE_ROUTE = "details/"
        const val FOOD_ID = "foodId"
    }

    object Home: Routes("home")
    object Details: Routes("$DETAILS_BASE_ROUTE{$FOOD_ID}") {
        fun getDynamicRoute(foodId: String) = "$DETAILS_BASE_ROUTE$foodId"
    }
}
