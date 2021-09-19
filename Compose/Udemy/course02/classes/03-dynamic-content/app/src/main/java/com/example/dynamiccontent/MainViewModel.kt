package com.example.dynamiccontent

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _textFieldState: MutableLiveData<String> = MutableLiveData()
    val textFieldState: LiveData<String> = _textFieldState
    val listNames = mutableStateListOf("Pierre")

    fun onTextChanged(newText: String) {
        _textFieldState.value = newText
    }

    fun addName() {
        _textFieldState.value?.let { name ->
            listNames.add(name)
        }
    }

    fun removeAllNames() {
        listNames.clear()
    }
}