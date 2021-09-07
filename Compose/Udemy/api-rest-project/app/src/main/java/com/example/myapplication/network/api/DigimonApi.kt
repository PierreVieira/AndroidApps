package com.example.myapplication.network.api

import com.example.myapplication.network.response.DigimonList
import retrofit2.http.GET

interface DigimonApi {

    @GET("digimon")
    suspend fun getDigimonList(): DigimonList
}