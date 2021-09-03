package com.example.planetas.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.example.planetas.model.items.Earth
import com.example.planetas.model.items.Jupiter
import com.example.planetas.model.items.Mars
import com.example.planetas.model.items.Mercury
import com.example.planetas.model.items.Neptune
import com.example.planetas.model.items.Saturn
import com.example.planetas.model.items.Uranus
import com.example.planetas.model.items.Venus


abstract class Planet(
    val name: String,
    val description: String,
    @DrawableRes val image: Int
) : Parcelable {
    companion object {
        val data = listOf(
            Mercury(),
            Venus(),
            Earth(),
            Mars(),
            Jupiter(),
            Saturn(),
            Uranus(),
            Neptune()
        )
    }
}
