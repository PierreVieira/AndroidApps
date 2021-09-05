package com.example.crud.ui.screens

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(navigateToDetailsAction: () -> Unit) {
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "App Crud") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { navigateToDetailsAction() }) {
                Icon(Icons.Filled.Add, contentDescription = "add")
            }
        }
    ) {}
}