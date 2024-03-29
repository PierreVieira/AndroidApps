package com.example.planetas.screens

import android.os.Bundle
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.planetas.MainActivity
import com.example.planetas.components.PlanetImage
import com.example.planetas.model.Planet

@Composable
fun HomeScreen(navController: NavHostController) {
    PlanetList(navController)
}

@Composable
private fun PlanetList(navController: NavHostController) {
    LazyColumn {
        itemsIndexed(Planet.data) { _, planet ->
            PlanetCard(planet, navController)
        }
    }
}

@Composable
private fun PlanetCard(planet: Planet, navController: NavHostController) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(
            width = 2.dp,
            color = Color(0x77f5f5f5),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .height(120.dp)
            .clickable {
                navigateToPlanet(navController, planet)
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            PlanetImage(planet = planet)
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                text = planet.name,
                style = TextStyle(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )
        }
    }
}


private fun navigateToPlanet(navController: NavHostController, planet: Planet) {
    navController.currentBackStackEntry?.arguments = Bundle().apply {
        putParcelable(MainActivity.PLANET_KEY, planet)
    }
    navController.navigate(MainActivity.DETAILS)
}