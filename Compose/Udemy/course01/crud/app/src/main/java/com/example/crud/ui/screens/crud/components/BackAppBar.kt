package com.example.crud.ui.screens.crud.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BackAppBar(text: String, backNavigation: () -> Unit) {
    TopAppBar(
        title = { Text(text = text) },
        navigationIcon = { BackArrowIcon(backNavigation) }
    )
}

@Composable
private fun BackArrowIcon(backNavigation: () -> Unit) {
    IconButton(onClick = { backNavigation() }) {
        Icon(Icons.Default.ArrowBack, contentDescription = "Back to previous screen")
    }
}

@Preview
@Composable
fun AppBarPreview() {
    BackAppBar("Registrar") { }
}