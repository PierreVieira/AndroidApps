package com.example.android.marsphotos.network

import com.example.android.marsphotos.network.MarsApiService.Companion.retrofit

object MarsApi {
    val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}