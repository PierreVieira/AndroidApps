package com.example.planetas.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.example.planetas.model.Planet

@Composable
fun PlanetList() {
    LazyColumn {
        itemsIndexed(Planet.data) { _, planet ->
            PlanetCard(planet = planet)
        }
    }
}