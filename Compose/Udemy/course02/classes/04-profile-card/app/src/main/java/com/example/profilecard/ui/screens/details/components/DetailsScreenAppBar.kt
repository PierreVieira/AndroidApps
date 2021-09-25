package com.example.profilecard.ui.screens.details.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.profilecard.ui.components.appBar.AppBarWithIcon
import com.example.profilecard.ui.theme.MyTheme

@Composable
fun DetailsScreenAppBar(name: String, backAction: () -> Unit) {
    AppBarWithIcon(
        title = "Details of $name",
        icon = Icons.Filled.ArrowBack,
        action = backAction
    )
}

@Preview
@Composable
private fun DetailsScreenAppBarPreview() {
    MyTheme {
        DetailsScreenAppBar(name = "Android 18", backAction = {})
    }
}