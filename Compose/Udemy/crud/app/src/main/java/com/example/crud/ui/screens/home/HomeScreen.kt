package com.example.crud.ui.screens.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.crud.data.entities.City
import com.example.crud.ui.screens.home.components.HomeAppBar
import com.example.crud.ui.screens.home.components.HomeFab
import com.example.crud.ui.screens.home.components.ListCard

@Composable
fun HomeScreen(
    cities: State<List<City>>,
    navigateToDetailsAction: () -> Unit,
    openCardDetailsAction: (Int) -> Unit
) {
    Scaffold(
        topBar = { HomeAppBar() },
        floatingActionButton = { HomeFab(navigateToDetailsAction) }
    ) {
        HomeContent(cities) { id -> openCardDetailsAction(id) }
    }
}

@Composable
private fun HomeContent(cities: State<List<City>>, openCardDetailsAction: (Int) -> Unit) {
    LazyColumn {
        items(cities.value) { city ->
            ListCard(city = city, clickAction = { city.id?.let { openCardDetailsAction(it) } })
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    val citiesNames = listOf(
        "Belo Horizonte",
        "Rio de Janeiro",
        "São Paulo",
        "Florianópolis",
        "Bahia",
        "Curitiba",
        "Brasília",
        "Palmas",
        "Varginha"
    )
    val cities = citiesNames.map { City(name = it) }
    val mockedCities: State<List<City>> = remember { mutableStateOf(cities) }
    HomeScreen(mockedCities, navigateToDetailsAction = {}, openCardDetailsAction = {})
}