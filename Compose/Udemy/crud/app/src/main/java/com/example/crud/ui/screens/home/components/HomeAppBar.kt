package com.example.crud.ui.screens.home.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeAppBar() {
    TopAppBar(title = { Text(text = "App Crud") })
}

@Preview
@Composable
fun HomeAppBarPreview() {
    HomeAppBar()
}