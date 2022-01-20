package com.example.waterme.adapter

import com.example.waterme.model.Plant

class PlantListener(val longClickListener: (plant: Plant) -> Boolean) {
    fun onLongClick(plant: Plant) = longClickListener(plant)
}