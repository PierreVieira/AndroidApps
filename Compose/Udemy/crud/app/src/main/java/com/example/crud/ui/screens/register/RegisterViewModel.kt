package com.example.crud.ui.screens.register

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crud.data.entities.City
import com.example.crud.repositories.CityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: CityRepository) : ViewModel() {
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

    private val _status: MutableLiveData<Boolean> = MutableLiveData()
    val status: LiveData<Boolean> = _status

    fun register() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                addCity()
            }
        }
    }

    private suspend fun addCity() {
        repository.addCity(City(name = cityName, cep = cityCep, uf = cityUf))
        _status.postValue(true)
    }
}