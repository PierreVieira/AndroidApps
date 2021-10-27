package com.example.firsttest

import android.content.Context
import androidx.annotation.StringRes

class ResourceCompare {
    fun isEqual(context: Context, @StringRes resId: Int, string: String): Boolean {
        return context.getString(resId) == string
    }
}