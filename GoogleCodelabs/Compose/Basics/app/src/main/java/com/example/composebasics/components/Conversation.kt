package com.example.composebasics.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composebasics.model.SampleData
import com.example.composebasics.model.Message
import com.example.composebasics.ui.theme.ComposeBasicsTheme

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) {
            MessageCard(message = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConversation() {
    ComposeBasicsTheme {
        Conversation(SampleData.conversationSample)
    }
}
