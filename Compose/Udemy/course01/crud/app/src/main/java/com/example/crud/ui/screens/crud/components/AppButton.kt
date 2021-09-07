package com.example.crud.ui.screens.crud.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppButton(text: String, onClick: () -> Unit) {
    Button(
        modifier = Modifier.padding(top = 16.dp),
        onClick = onClick
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun AppButtonPreview() {
    AppButton(text = "REGISTER") {}
}