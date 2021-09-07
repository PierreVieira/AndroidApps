package com.example.myapplication.network.api

import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class DigimonRepository @Inject constructor(private val api: DigimonApi) {
    suspend fun getDigimonList() = api.getDigimonList()
}