package com.example.planetas.model.items

import com.example.planetas.R
import com.example.planetas.model.Planet
import kotlinx.parcelize.Parcelize

@Parcelize
class Earth: Planet(
    name = "Terra",
    description = "É o nosso lar!",
    image = R.drawable.earth
)