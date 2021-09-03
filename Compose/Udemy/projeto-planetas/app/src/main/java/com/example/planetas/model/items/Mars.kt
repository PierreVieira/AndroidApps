package com.example.planetas.model.items

import com.example.planetas.R
import com.example.planetas.model.Planet
import kotlinx.parcelize.Parcelize

@Parcelize
class Mars: Planet(
    name = "Mars",
    description = "Nosso vizinho vermelho",
    image = R.drawable.mars
)