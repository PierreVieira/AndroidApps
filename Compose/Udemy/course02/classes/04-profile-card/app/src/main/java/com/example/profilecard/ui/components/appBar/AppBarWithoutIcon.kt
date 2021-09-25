package com.example.profilecard.ui.components.appBar

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.profilecard.ui.theme.MyTheme

@Composable
internal fun AppBarWithoutIcon(title: String) {
    TopAppBar(
        title = { Text(text = title) }
    )
}

@Composable
@Preview
private fun AppBarWithoutIconPreview() {
    MyTheme {
        AppBarWithoutIcon(title = "Home")
    }
}