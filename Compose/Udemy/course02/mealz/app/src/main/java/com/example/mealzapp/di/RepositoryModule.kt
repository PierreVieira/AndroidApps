package com.example.mealzapp.di

import com.example.mealzapp.network.MealsApi
import com.example.mealzapp.network.MealsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRepository(api: MealsApi): MealsRepository = MealsRepository(api)

    @Provides
    @Singleton
    fun provideMealsApi(): MealsApi = Retrofit.Builder()
        .baseUrl(MealsApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MealsApi::class.java)
}