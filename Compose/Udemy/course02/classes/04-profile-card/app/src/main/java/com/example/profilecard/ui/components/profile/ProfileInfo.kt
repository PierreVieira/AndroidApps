package com.example.profilecard.ui.components.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profilecard.ui.theme.MyTheme

@Composable
fun ProfileInfo(name: String, online: Boolean, alignment: Alignment.Horizontal) {
    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = alignment
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
@Preview(showBackground = true)
private fun ProfileInfoPreview() {
    MyTheme {
        ProfileInfo(
            name = "Android 18",
            online = true,
            alignment = Alignment.Start
        )
    }
}