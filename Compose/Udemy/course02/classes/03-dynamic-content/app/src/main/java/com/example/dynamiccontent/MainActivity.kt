package com.example.dynamiccontent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dynamiccontent.ui.theme.DynamicContentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DynamicContentTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: MainViewModel = MainViewModel()) {
    val newNameStateContent = viewModel.textFieldState.observeAsState("")
    val listNames = remember { viewModel.listNames }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingContent(
            names = listNames,
            textFieldValue = newNameStateContent.value,
            textFieldUpdate = { viewModel.onTextChanged(it) },
            addToListAction = { viewModel.addName() },
            removeAllNamesAction = { viewModel.removeAllNames() }
        )
    }
}

@Composable
private fun GreetingContent(
    names: List<String>,
    textFieldValue: String,
    textFieldUpdate: (newName: String) -> Unit,
    addToListAction: () -> Unit,
    removeAllNamesAction: () -> Unit,
) {
    NameTextField(textFieldValue, textFieldUpdate)
    AddNameButton(addToListAction)
    RemoveNamesButton(removeAllNamesAction)
    ListNames(names)
}

@Composable
private fun NameTextField(
    textFieldValue: String,
    textFieldUpdate: (newName: String) -> Unit
) {
    OutlinedTextField(
        label = { Text(text = "Name") },
        value = textFieldValue,
        onValueChange = textFieldUpdate
    )
}

@Composable
private fun AddNameButton(addToListAction: () -> Unit) {
    Button(
        modifier = Modifier
            .padding(vertical = 16.dp),
        onClick = { addToListAction() }
    ) {
        Text(text = "Add new name")
    }
}

@Composable
private fun RemoveNamesButton(removeAllNamesAction: () -> Unit) {
    Button(
        modifier = Modifier
            .padding(bottom = 32.dp),
        onClick = { removeAllNamesAction() }
    ) {
        Text(text = "Remove all names")
    }
}

@Composable
private fun ListNames(names: List<String>) {
    LazyColumn {
        itemsIndexed(names) { index, name ->
            Greeting(name = name, position = index + 1)
        }
    }
}

@Composable
fun Greeting(name: String, position: Int) {
    Text(
        text = "$position: $name",
        style = MaterialTheme.typography.h5
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}