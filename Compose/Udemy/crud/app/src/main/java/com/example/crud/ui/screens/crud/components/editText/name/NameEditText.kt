package com.example.crud.ui.screens.crud.components.editText.name

import androidx.compose.runtime.Composable
import com.example.crud.ui.screens.crud.CrudViewModel
import com.example.crud.ui.screens.crud.components.editText.EditTextField

private const val NAME_PLACEHOLDER = "Nome"

@Composable
fun NameEditText(viewModel: CrudViewModel) {
    EditTextField(
        labelText = NAME_PLACEHOLDER,
        value = viewModel.cityName,
        onValueChanged = { viewModel.cityName = it }
    )
}