package com.example.profilecard.navigation

sealed class Routes(val value: String) {

    companion object {
        private const val DETAILS_BASE_ROUTE = "details/"
        const val USER_ID = "userId"
    }

    object Home: Routes("home")
    object Details: Routes("$DETAILS_BASE_ROUTE{$USER_ID}") {
        fun getDynamicRoute(id: String) = "$DETAILS_BASE_ROUTE$id"
    }
}