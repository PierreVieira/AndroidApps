package com.example.crud.ui.screens.register

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.crud.ui.screens.crud.CrudScreen
import com.example.crud.ui.screens.crud.components.AppButton

private const val REGISTER_TITLE_BAR = "Cadastrar Cidade"
private const val REGISTER_BUTTON_TEXT = "CADASTRAR"
@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = hiltViewModel(),
    popNavigation: () -> Unit
) {
    CrudScreen(
        title = REGISTER_TITLE_BAR,
        viewModel = viewModel,
        popNavigation = { popNavigation() }) {
        AppButton(text = REGISTER_BUTTON_TEXT, onClick = {
            viewModel.register()
            popNavigation()
        })
    }
}
