package com.example.profilecard.ui.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profilecard.model.User
import com.example.profilecard.model.userList
import com.example.profilecard.ui.components.profile.ProfileInfo
import com.example.profilecard.ui.components.profile.ProfilePicture
import com.example.profilecard.ui.theme.MyTheme

@Composable
fun ProfileCard(user: User, openDetailsAction: (User) -> Unit) {
    Card(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .clickable {
                openDetailsAction(user)
            },
        elevation = 8.dp,
        backgroundColor = Color.White,
        shape = CutCornerShape(topEnd = 24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(
                imageUrl = user.imageUrl,
                imageSize = 72.dp,
                online = user.online
            )
            ProfileInfo(
                name = user.name,
                online = user.online,
                alignment = Alignment.Start
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun ProfileCardPreview() {
    MyTheme {
        ProfileCard(
            user = userList[0],
            openDetailsAction = {}
        )
    }
}