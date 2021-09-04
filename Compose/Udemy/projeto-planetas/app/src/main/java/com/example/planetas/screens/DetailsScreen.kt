package com.example.planetas.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.planetas.components.PlanetImage
import com.example.planetas.model.Planet

@Composable
fun DetailsScreen(planet: Planet, navController: NavController) {
    Column(Modifier.fillMaxWidth()) {
        PlanetDetails(planet)
        BackButton(navController)
    }
}

@Composable
fun BackButton(navController: NavController) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        onClick = { navController.popBackStack() }
    ) {
        Text(text = "Voltar")
    }
}

@Composable
private fun PlanetDetails(planet: Planet) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(16.dp),
    ) {
        PlanetImage(planet)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = planet.name,
                style = TextStyle(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = planet.description,
                textAlign = TextAlign.Center
            )
        }
    }
}