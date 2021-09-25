package com.example.profilecard.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.profilecard.model.User
import com.example.profilecard.model.userList
import com.example.profilecard.ui.screens.home.components.HomeAppBar
import com.example.profilecard.ui.screens.home.components.ProfileCard
import com.example.profilecard.ui.theme.MyTheme

@Composable
fun HomeScreen(openDetailsAction: (User) -> Unit, originalUserList: List<User> = userList) {
    val users = originalUserList.toMutableList()
    users.sortByDescending { it.online }
    Scaffold(
        topBar = { HomeAppBar() }
    ) {
        HomeContent(
            openDetailsAction = openDetailsAction,
            users = users
        )
    }
}

@Composable
private fun HomeContent(openDetailsAction: (User) -> Unit, users: MutableList<User>) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyColumn {
            items(users) {
                ProfileCard(
                    user = it,
                    openDetailsAction = openDetailsAction
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    MyTheme {
        HomeScreen(openDetailsAction = {})
    }
}

