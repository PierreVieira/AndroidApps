package com.example.crud.navigation

sealed class Routes(val value: String) {

    companion object {
        private const val DETAILS_BASE_ROUTE = "details/"
        const val CITY_ID = "cityId"
    }

    object Home: Routes("home")
    object Register: Routes("register")
    object Details: Routes("$DETAILS_BASE_ROUTE{$CITY_ID}") {
        fun getDynamicRoute(cityId: Int) = "$DETAILS_BASE_ROUTE$cityId"
    }
}