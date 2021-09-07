package com.example.crud.repositories.city

import com.example.crud.data.entities.City

interface CityRepositoryInterface {
    suspend fun addCity(city: City)
    suspend fun updateCity(city: City)
    suspend fun deleteCity(city: City)
    suspend fun getCityById(id: Int) : City?
}