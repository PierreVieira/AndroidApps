package com.example.myapplication.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.myapplication.network.response.Digimon

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    Scaffold(topBar = { TopAppBar(title = { Text("Digimons") }) }) {
        HomeContent(viewModel)
    }
}

@Composable
private fun HomeContent(viewModel: HomeViewModel) {
    LazyColumn {
        items(viewModel.digimonList.value) { digimon ->
            DigimonDetails(digimon)
        }
    }
}

@Composable
private fun DigimonDetails(digimon: Digimon) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(96.dp)
    ) {
        DigimonImage(
            image = digimon.img
        )
        DigimonInfo(
            name = digimon.name,
            level = digimon.level
        )
    }
}

@Composable
private fun DigimonInfo(name: String, level: String) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = name,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = level
        )
    }
}

@Composable
private fun DigimonImage(image: String) {
    Image(
        modifier = Modifier
            .height(80.dp)
            .padding(start = 16.dp),
        painter = rememberImagePainter(image),
        contentDescription = null
    )
}
