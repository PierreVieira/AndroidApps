package com.example.crud.di

import android.content.Context
import androidx.room.Room
import com.example.crud.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext applicationContext: Context) = Room
        .databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "dbRoomCompose"
        )
        .build()

    @Provides
    fun provideCityRepository(db: AppDatabase) = db.getCityDao()
}