package com.example.myapplication.network.response


import com.google.gson.annotations.SerializedName

data class Digimon(
    @SerializedName("img")
    val img: String,
    @SerializedName("level")
    val level: String,
    @SerializedName("name")
    val name: String
)