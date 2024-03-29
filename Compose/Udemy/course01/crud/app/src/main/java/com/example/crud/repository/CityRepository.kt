package com.example.crud.repository

import com.example.crud.data.database.AppDatabase
import com.example.crud.data.entities.City
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CityRepository @Inject constructor(appDatabase: AppDatabase) : CityRepositoryInterface {
    private val dao by lazy { appDatabase.getCityDao() }

    val allCities by lazy { dao.getAllCities() }

    override suspend fun addCity(city: City) = dao.insert(city)

    override suspend fun updateCity(city: City) = dao.update(city)

    override suspend fun deleteCity(city: City) = dao.delete(city)

    override suspend fun getCityById(id: Int) = dao.getCityById(id)

}