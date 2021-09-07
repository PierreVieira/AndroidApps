package com.example.crud.ui.screens.crud.components.editText

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EditTextField(
    labelText: String,
    value: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.padding(top = 8.dp),
        label = { Text(text = labelText) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        value = value,
        onValueChange = onValueChanged,
        visualTransformation = visualTransformation
    )
}

@Composable
@Preview
fun EditTextFieldPreview() {
    EditTextField(labelText = "Nome", value = "", onValueChanged = {})
}