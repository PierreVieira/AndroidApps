package com.example.profilecard.ui.screens.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.profilecard.R
import com.example.profilecard.model.User
import com.example.profilecard.ui.theme.lightGreen

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
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(user.imageUrl, user.online)
            ProfileInfo(user.name, user.online)
        }
    }
}

@Composable
private fun ProfilePicture(imageUrl: String, online: Boolean) {
    Card(
        modifier = Modifier.padding(16.dp),
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = if (online) MaterialTheme.colors.lightGreen else Color.Red
        ),
        elevation = 4.dp
    ) {
        Image(
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop,
            painter = rememberImagePainter(
                data = imageUrl,
                builder = {
                    crossfade(true)
                    placeholder(R.drawable.user_placeholder)
                    transformations(CircleCropTransformation())
                },
            ),
            contentDescription = null,
        )
    }
}

@Composable
private fun ProfileInfo(name: String, online: Boolean) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        CompositionLocalProvider(LocalContentAlpha provides (if (online) 1f else ContentAlpha.medium)) {
            Text(
                text = name,
                style = MaterialTheme.typography.h5
            )
        }
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = if (online) "Active now" else "Offline",
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Composable
@Preview
private fun ProfileCardPreview() {
    ProfileCard(
        user = User(
            id = "android-18",
            name = "Android 18",
            imageUrl = "https://pm1.narvii.com/5943/b5ae3a69a0e08513ce9d1fe2a8cee85f6082c4fc_hq.jpg",
            online = true
        ),
        openDetailsAction = {}
    )
}