package com.example.composebasics.model

import androidx.annotation.DrawableRes
import com.example.composebasics.R

data class Author(val name: String, @DrawableRes val picture: Int) {
    companion object {
        val pierre = Author(name = "Pierre Vieira", picture = R.drawable.pierre_vieira_profile)
        val android = Author(name = "Android", picture = R.drawable.android_18_profile_picture)
    }
}