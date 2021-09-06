package com.example.crud.repositories

import com.example.crud.data.database.AppDatabase
import com.example.crud.data.entities.City
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CityRepository @Inject constructor(appDatabase: AppDatabase) {
    private val dao by lazy { appDatabase.getCityDao() }

    val allCities by lazy { dao.getAllCities() }

    suspend fun addCity(city: City) = dao.insert(city)

    suspend fun updateCity(city: City) = dao.update(city)

    suspend fun deleteCity(city: City) = dao.delete(city)

    suspend fun getCityById(id: Int) = dao.getCityById(id)

}