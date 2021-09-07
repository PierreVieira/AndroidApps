package com.example.crud.ui.screens.crud.details

import androidx.lifecycle.viewModelScope
import com.example.crud.data.entities.City
import com.example.crud.repository.CityRepository
import com.example.crud.ui.screens.crud.CrudViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: CityRepository) :
    CrudViewModel() {
    fun change(cityId: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.updateCity(
                    City(
                        id = cityId,
                        name = cityName,
                        cep = cityCep,
                        uf = cityUf
                    )
                )
            }
        }
    }

    fun delete(cityId: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.deleteCity(
                    City(
                        id = cityId,
                        name = cityName,
                        cep = cityCep,
                        uf = cityUf
                    )
                )
            }
        }
    }

    fun setInfoById(cityId: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val city = getCityById(cityId)
                withContext(Dispatchers.Main) {
                    cityName = city?.name ?: ""
                    cityCep = city?.cep ?: ""
                    cityUf = city?.uf ?: ""
                }
            }
        }
    }

    private suspend fun getCityById(cityId: Int) = repository.getCityById(cityId)
}