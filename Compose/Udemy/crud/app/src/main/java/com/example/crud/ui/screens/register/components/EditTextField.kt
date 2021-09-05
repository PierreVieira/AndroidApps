package com.example.crud.ui.screens.register.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun EditTextField(
    labelText: String,
    value: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.padding(top = 8.dp),
        label = { Text(text = labelText) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        value = value,
        onValueChange = onValueChanged
    )
}