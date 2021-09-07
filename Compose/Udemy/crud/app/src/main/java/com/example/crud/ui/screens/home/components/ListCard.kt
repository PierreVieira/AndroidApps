package com.example.crud.ui.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.crud.data.entities.City

@Composable
fun ListCard(city: City, clickAction: () -> Unit) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(8.dp)
            .clickable { clickAction() }
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = city.name.toString(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun ListCardPreview() {
    val city = City(name = "Belo Horizonte")
    ListCard(city = city) {}
}