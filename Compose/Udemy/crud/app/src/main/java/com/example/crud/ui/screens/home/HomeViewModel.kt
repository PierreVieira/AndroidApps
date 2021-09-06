package com.example.crud.ui.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.crud.data.entities.City
import com.example.crud.repositories.CityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(repository: CityRepository) : ViewModel() {
    val cities: LiveData<List<City>> = repository.allCities.asLiveData()
}