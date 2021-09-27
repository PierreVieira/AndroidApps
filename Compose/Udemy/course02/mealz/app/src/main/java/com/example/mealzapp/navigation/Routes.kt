package com.example.mealzapp.navigation

sealed class Routes(val value: String) {
    object Home: Routes("home")
}
