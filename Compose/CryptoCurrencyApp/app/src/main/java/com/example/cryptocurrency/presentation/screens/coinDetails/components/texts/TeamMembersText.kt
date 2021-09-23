package com.example.cryptocurrency.presentation.screens.coinDetails.components.texts

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.cryptocurrency.presentation.ui.theme.CryptoCurrenciesTheme

@Composable
fun TeamMembersText() {
    Text(
        text = "Team members",
        style = MaterialTheme.typography.h3
    )
}

@Composable
@Preview(showBackground = true)
private fun TeamMembersTextPreview() {
    CryptoCurrenciesTheme {
        TeamMembersText()
    }
}