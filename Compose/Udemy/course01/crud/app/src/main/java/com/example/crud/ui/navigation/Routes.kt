package com.example.crud.ui.navigation

object Routes {
    private const val DETAILS_BASE_ROUTE = "details/"
    const val HOME = "home"
    const val REGISTER = "register"
    const val CITY_ID_KEY = "cityId"
    const val DETAILS = "$DETAILS_BASE_ROUTE{$CITY_ID_KEY}"

    fun getDetailsDynamicRoute(cityId: Int) = "$DETAILS_BASE_ROUTE${cityId}"
}