package com.example.planetas.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.planetas.model.Planet

@Composable
fun PlanetImage(planet: Planet) {
    Image(
        modifier = Modifier
            .height(100.dp)
            .width(100.dp),
        painter = painterResource(id = planet.image),
        contentDescription = "Imagem do planeta ${planet.name}"
    )
}