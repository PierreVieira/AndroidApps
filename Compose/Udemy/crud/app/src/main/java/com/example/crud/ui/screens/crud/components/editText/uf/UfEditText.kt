package com.example.crud.ui.screens.crud.components.editText.uf

import androidx.compose.runtime.Composable
import com.example.crud.ui.screens.crud.CrudViewModel
import com.example.crud.ui.screens.crud.components.editText.EditTextField

private const val UF_PLACEHOLDER = "UF"

@Composable
fun UfEditText(viewModel: CrudViewModel) {
    EditTextField(
        labelText = UF_PLACEHOLDER,
        value = viewModel.cityUf,
        visualTransformation = UfTransformation(),
        onValueChanged = { viewModel.cityUf = it }
    )
}