package com.example.mealzapp.ui.screens.home

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.mealzapp.model.response.MealResponse

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel(), navToDetailsAction: (String) -> Unit) {
    val meals = viewModel.mealsState.value
    LazyColumn(
        contentPadding = PaddingValues(16.dp)
    ) {
        items(meals) {
            MealCard(it, navToDetailsAction)
        }
    }
}

@Composable
private fun MealCard(meal: MealResponse, navToDetailsAction: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clickable { navToDetailsAction(meal.id) },
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp
    ) {
        MealContentCard(meal)
    }
}

@Composable
private fun MealContentCard(meal: MealResponse) {
    var isExpanded by remember { mutableStateOf(false) }

    Row(modifier = Modifier.animateContentSize()) {
        Image(
            painter = rememberImagePainter(meal.imageUrl),
            contentDescription = null,
            modifier = Modifier
                .size(88.dp)
                .padding(4.dp)
                .align(Alignment.CenterVertically)
        )
        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxWidth(0.8f)
                .padding(16.dp)
        ) {
            Text(
                text = meal.name,
                style = MaterialTheme.typography.h6
            )
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = meal.description,
                    style = MaterialTheme.typography.subtitle2,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = if (isExpanded) 10 else 3
                )
            }
        }
        Icon(
            imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = "Expand row icon",
            modifier = Modifier
                .align(if (isExpanded) Alignment.Bottom else Alignment.CenterVertically)
                .padding(16.dp)
                .clickable { isExpanded = !isExpanded }
        )
    }
}
