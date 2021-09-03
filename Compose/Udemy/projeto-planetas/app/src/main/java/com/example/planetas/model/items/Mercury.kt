package com.example.planetas.model.items

import com.example.planetas.R
import com.example.planetas.model.Planet
import kotlinx.parcelize.Parcelize

@Parcelize
class Mercury : Planet(
    name = "Mercúrio",
    description = "Planeta mais próximo do sol",
    image = R.drawable.mercury
)