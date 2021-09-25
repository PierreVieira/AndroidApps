package com.example.profilecard.ui.components.appBar

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profilecard.ui.theme.MyTheme

@Composable
internal fun AppBarWithIcon(title: String, icon: ImageVector, action: (() -> Unit)) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { action() }) {
                Icon(
                    modifier = Modifier.padding(start = 8.dp),
                    imageVector = icon,
                    contentDescription = null
                )
            }
        },
        title = { Text(text = title) }
    )
}

@Composable
@Preview
private fun AppBarWithIconPreview() {
    MyTheme {
        AppBarWithIcon(
            title = "Back to previous screen",
            icon = Icons.Filled.ArrowBack,
            action = {}
        )
    }
}