package com.example.planetas.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.planetas.model.Planet

@Composable
fun PlanetCard(planet: Planet) {
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

            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Image(
                painter = painterResource(id = planet.image),
                contentDescription = "Imagem do planeta ${planet.name}"
            )
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