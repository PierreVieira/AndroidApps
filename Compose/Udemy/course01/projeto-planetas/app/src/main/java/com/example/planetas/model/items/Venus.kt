package com.example.planetas.model.items

import com.example.planetas.R
import com.example.planetas.model.Planet
import kotlinx.parcelize.Parcelize

@Parcelize
class Venus : Planet(
    name = "Vênus",
    description = "Planeta mais quente do sistema solar",
    image = R.drawable.venus
)