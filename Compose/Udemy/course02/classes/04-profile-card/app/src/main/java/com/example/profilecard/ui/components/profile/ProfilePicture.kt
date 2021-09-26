package com.example.profilecard.ui.components.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.profilecard.R
import com.example.profilecard.ui.theme.MyTheme
import com.example.profilecard.ui.theme.lightGreen

@Composable
fun ProfilePicture(imageUrl: String, imageSize: Dp, online: Boolean) {
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
            modifier = Modifier.size(imageSize),
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
@Preview(showBackground = true)
private fun ProfilePicturePreview() {
    MyTheme {
        ProfilePicture(imageUrl = "", imageSize = 72.dp, online = true)
    }
}