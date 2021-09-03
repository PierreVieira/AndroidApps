package com.example.planetas.model.items

import com.example.planetas.R
import com.example.planetas.model.Planet
import kotlinx.parcelize.Parcelize

@Parcelize
class Jupiter : Planet(
    name = "Jupiter",
    description = "É o maior planeta do sistema solar",
    image = R.drawable.jupiter
)