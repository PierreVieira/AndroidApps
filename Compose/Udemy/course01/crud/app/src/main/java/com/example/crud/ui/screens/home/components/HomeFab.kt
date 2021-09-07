package com.example.crud.ui.screens.home.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeFab(navigateToDetailsAction: () -> Unit) {
    FloatingActionButton(onClick = { navigateToDetailsAction() }) {
        Icon(Icons.Filled.Add, contentDescription = "add")
    }
}

@Preview
@Composable
fun HomeFabPreview() {
    HomeFab {}
}
