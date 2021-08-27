package com.example.expandablecardwithanimation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun ExpandableCard() {
    var expandadeState by remember { mutableStateOf(false) }

}