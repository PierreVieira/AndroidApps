package com.example.profilecard.ui.screens.home.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.profilecard.ui.components.appBar.AppBar

@Composable
fun HomeAppBar() {
    AppBar(
        title = "Messaging Application Users"
    )
}

@Preview
@Composable
fun HomeAppBarPreview() {
    HomeAppBar()
}