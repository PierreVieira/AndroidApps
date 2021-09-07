package com.example.crud.ui.screens.crud

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.crud.ui.screens.crud.components.BackAppBar
import com.example.crud.ui.screens.crud.components.editText.cep.CepEditText
import com.example.crud.ui.screens.crud.components.editText.name.NameEditText
import com.example.crud.ui.screens.crud.components.editText.uf.UfEditText

@Composable
fun CrudScreen(
    title: String,
    viewModel: CrudViewModel,
    popNavigation: () -> Unit,
    buttons: @Composable () -> Unit
) {
    val status = viewModel.status.observeAsState()
    if (status.value == true) {
        popNavigation()
    }
    Scaffold(topBar = { BackAppBar(title) { popNavigation() } }) {
        ContentScreen(viewModel) { buttons() }
    }
}

@Composable
private fun ContentScreen(viewModel: CrudViewModel, buttons: @Composable () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NameEditText(viewModel)
        CepEditText(viewModel)
        UfEditText(viewModel)
        buttons()
    }
}

