package com.example.profilecard.ui.screens.details

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.profilecard.model.User
import com.example.profilecard.ui.screens.details.components.DetailsScreenAppBar

@Composable
fun DetailsScreen(user: User, backAction: () -> Unit) {
    Scaffold(
        topBar = {
            DetailsScreenAppBar(
                name = user.name,
                backAction = backAction
            )
        }
    ) {
        DetailsScreenContent(user)
    }
}

@Composable
fun DetailsScreenContent(user: User) {

}
