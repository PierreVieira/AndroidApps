package com.example.crud.ui.screens.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.crud.data.entities.City
import com.example.crud.ui.screens.home.components.HomeAppBar
import com.example.crud.ui.screens.home.components.HomeFab
import com.example.crud.ui.screens.home.components.ListCard

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToDetailsAction: () -> Unit,
    openCardDetailsAction: (Int) -> Unit
) {
    val cities = viewModel.cities.observeAsState(listOf())
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
