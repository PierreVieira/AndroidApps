package com.example.crud.ui.screens.crud.components.editText.cep

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType
import com.example.crud.ui.screens.crud.CrudViewModel
import com.example.crud.ui.screens.crud.components.EditTextField

private const val CEP_PLACEHOLDER = "CEP"

@Composable
fun CepEditText(viewModel: CrudViewModel) {
    EditTextField(
        labelText = CEP_PLACEHOLDER,
        keyboardType = KeyboardType.Number,
        value = viewModel.cityCep,
        visualTransformation = CepTransformation(),
        onValueChanged = { viewModel.cityCep = it }
    )
}