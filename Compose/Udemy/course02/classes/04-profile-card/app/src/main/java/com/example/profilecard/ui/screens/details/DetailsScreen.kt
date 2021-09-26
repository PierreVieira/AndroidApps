package com.example.profilecard.ui.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profilecard.model.User
import com.example.profilecard.model.userList
import com.example.profilecard.ui.components.profile.ProfileInfo
import com.example.profilecard.ui.components.profile.ProfilePicture
import com.example.profilecard.ui.screens.details.components.DetailsScreenAppBar
import com.example.profilecard.ui.theme.MyTheme

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
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            ProfilePicture(
                imageUrl = user.imageUrl,
                imageSize = 240.dp,
                online = user.online
            )
            ProfileInfo(
                name = user.name,
                online = user.online,
                alignment = Alignment.CenterHorizontally
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DetailsScreenPreview() {
    MyTheme {
        DetailsScreen(user = userList[0], backAction = {})
    }
}
