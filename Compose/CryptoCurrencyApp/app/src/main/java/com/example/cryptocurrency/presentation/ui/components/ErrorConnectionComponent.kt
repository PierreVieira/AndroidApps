package com.example.cryptocurrency.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptocurrency.R
import com.example.cryptocurrency.presentation.ui.theme.CryptoCurrenciesTheme

@Composable
fun ErrorConnectionComponent(
    reconnectAction: () -> Unit,
    errorText: String = "An unexpected error occurred"
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(36.dp),
            painter = painterResource(id = R.drawable.ic_cloud_off),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.error)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = errorText,
            color = MaterialTheme.colors.error,
            style = TextStyle(
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = reconnectAction) {
            Text(text = "Try reconnect")
        }
    }
}

@Composable
@Preview
fun ErrorTextPreview() {
    CryptoCurrenciesTheme {
        ErrorConnectionComponent(reconnectAction = {})
    }
}