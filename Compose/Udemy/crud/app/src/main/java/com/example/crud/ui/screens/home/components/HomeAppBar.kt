package com.example.crud.ui.screens.home.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun HomeAppBar() {
    TopAppBar(title = { Text(text = "App Crud") })
}