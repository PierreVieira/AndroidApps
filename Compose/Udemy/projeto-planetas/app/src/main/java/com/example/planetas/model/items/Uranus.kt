package com.example.planetas.model.items

import com.example.planetas.R
import com.example.planetas.model.Planet
import kotlinx.parcelize.Parcelize

@Parcelize
class Uranus : Planet(
    name = "Urano",
    description = "Penúltimo planeta do sistema solar",
    image = R.drawable.uranus
)