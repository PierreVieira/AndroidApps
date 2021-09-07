package com.example.planetas.model.items

import com.example.planetas.R
import com.example.planetas.model.Planet
import kotlinx.parcelize.Parcelize

@Parcelize
class Saturn: Planet(
    name = "Saturno",
    description = "Possui lindos anéis e é o segundo maior planeta do sistema solar",
    image = R.drawable.saturn
)