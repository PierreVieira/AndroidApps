package com.example.crud.ui.screens.crud.details

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.crud.ui.screens.crud.CrudScreen
import com.example.crud.ui.screens.crud.components.AppButton

private const val DETAILS_TITLE = "Detalhes"
private const val CHANGE_TEXT = "ALTERAR"
private const val DELETE_TEXT = "EXCLUIR"

@Composable
fun DetailScreen(
    cityId: Int,
    viewModel: DetailsViewModel = hiltViewModel(),
    popNavigation: () -> Unit
) {
    viewModel.setInfoById(cityId)
    CrudScreen(title = DETAILS_TITLE, viewModel = viewModel, popNavigation = { popNavigation() }) {
        Row {
            AppButton(text = DELETE_TEXT, onClick = {
                popNavigation()
                viewModel.delete(cityId)
            })
            Spacer(Modifier.width(8.dp))
            AppButton(text = CHANGE_TEXT, onClick = {
                popNavigation()
                viewModel.change(cityId)
            })
        }
    }
}