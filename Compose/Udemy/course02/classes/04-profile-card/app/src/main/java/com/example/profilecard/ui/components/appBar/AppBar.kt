package com.example.profilecard.ui.components.appBar

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun AppBar(title: String, icon: ImageVector? = null, action: (() -> Unit)? = null) {
    icon?.let {
        action?.let {
            AppBarWithIcon(title, icon, action)
        }
    } ?: AppBarWithoutIcon(title)
}
