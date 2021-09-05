package com.example.crud.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.crud.data.dao.CityDao
import com.example.crud.data.entities.City

@Database(entities = [City::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCityDao() : CityDao
}