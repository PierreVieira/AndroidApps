package com.example.crud.ui.screens.register

import androidx.lifecycle.viewModelScope
import com.example.crud.data.entities.City
import com.example.crud.repositories.CityRepository
import com.example.crud.ui.screens.crud.CrudViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: CityRepository) :
    CrudViewModel() {

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