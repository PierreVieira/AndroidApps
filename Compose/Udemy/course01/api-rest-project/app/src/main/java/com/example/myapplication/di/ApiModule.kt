package com.example.myapplication.di

import com.example.myapplication.network.api.DigimonApi
import com.example.myapplication.network.api.DigimonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Singleton
    @Provides
    fun provideDigimonRepository(api: DigimonApi) = DigimonRepository(api)

    @Singleton
    @Provides
    fun provideDigimonApi(): DigimonApi = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://digimon-api.vercel.app/api/")
        .build()
        .create(DigimonApi::class.java)
}