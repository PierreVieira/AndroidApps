package com.example.crud.ui.screens.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.crud.ui.screens.register.components.EditTextField
import com.example.crud.ui.screens.register.components.RegisterAppBar
import com.example.crud.ui.screens.register.components.RegisterButton

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = hiltViewModel(),
    backNavigation: () -> Unit
) {
    val status = viewModel.status.observeAsState()
    if (status.value == true) {
        backNavigation()
    }
    Scaffold(topBar = { RegisterAppBar { backNavigation() } }) {
        ContentScreen(viewModel)
    }
}

@Composable
private fun ContentScreen(viewModel: RegisterViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EditTextField(
            labelText = "Nome",
            value = viewModel.cityName,
            onValueChanged = { viewModel.cityName = it.trim() }
        )
        EditTextField(
            labelText = "CEP",
            keyboardType = KeyboardType.Number,
            value = viewModel.cityCep,
            onValueChanged = { viewModel.cityCep = it.trim() }
        )
        EditTextField(
            labelText = "UF",
            value = viewModel.cityUf,
            onValueChanged = { viewModel.cityUf = it.trim() }
        )
        RegisterButton { viewModel.register() }
    }
}
