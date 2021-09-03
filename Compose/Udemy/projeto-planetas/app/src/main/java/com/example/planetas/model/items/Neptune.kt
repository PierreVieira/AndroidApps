package com.example.planetas.model.items

import com.example.planetas.R
import com.example.planetas.model.Planet
import kotlinx.parcelize.Parcelize

@Parcelize
class Neptune : Planet(
    name = "Netuno",
    description = "Último e mais gelado planeta do sistema solar",
    image = R.drawable.neptune
)