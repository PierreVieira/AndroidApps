package com.example.crud.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.crud.data.entities.City
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {
    @Insert
    suspend fun insert(city: City)

    @Update
    suspend fun update(city: City)

    @Delete
    suspend fun delete(city: City)

    @Query("SELECT * FROM cities")
    fun getAllCities(): Flow<List<City>>

    @Query("SELECT * FROM cities WHERE id == :cityId")
    suspend fun getCityById(cityId: Int): City?
}