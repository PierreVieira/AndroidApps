package com.example.crud.ui.screens.register.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RegisterAppBar(backNavigation: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Registrar") },
        navigationIcon = {
            IconButton(onClick = { backNavigation() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back to previous screen")
            }
        }
    )
}

@Preview
@Composable
fun AppBarPreview() {
    RegisterAppBar { }
}