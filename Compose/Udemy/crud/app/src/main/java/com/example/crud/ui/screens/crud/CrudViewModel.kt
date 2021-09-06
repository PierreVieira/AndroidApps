package com.example.crud.ui.screens.crud

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class CrudViewModel : ViewModel() {
    protected val _status: MutableLiveData<Boolean> = MutableLiveData()
    val status: LiveData<Boolean> = _status
    private val _cityName = mutableStateOf("")
    var cityName: String
        get() = _cityName.value
        set(name) {
            _cityName.value = name
        }

    private val _cityCep = mutableStateOf("")
    var cityCep: String
        get() = _cityCep.value
        set(name) {
            _cityCep.value = name
        }

    private val _cityUf = mutableStateOf("")
    var cityUf: String
        get() = _cityUf.value
        set(name) {
            _cityUf.value = name
        }
}