package com.example.moonphases

import androidx.annotation.DrawableRes

data class DayData (
    val dayOfMonth: Int,
    var moonPhase: MoonPhase
)

enum class MoonPhase(val value: Int, val phase: String, val drawableRes: Int){
    FULL_MOON(0, "full moon", R.drawable.ic_full_moon),
    FIRST_QUARTER(1, "first quarter", R.drawable.ic_first_quarter),
    NEW_MOON(2, "new moon", R.drawable.ic_new_moon),
    THIRD_QUARTER(3, "third_quarter", R.drawable.ic_third_quarter),
    WANING_CRESCENT(4, "waning crescent", R.drawable.ic_waning_crescent),
    WANING_GIBBOUS(5, "waning gibbous", R.drawable.ic_waning_gibbous),
    WAXING_CRESCENT(6, "waxing crescent", R.drawable.ic_waxing_crescent),
    WAXING_GIBBOUS(7, "waxing gibbous", R.drawable.ic_waxing_gibbous);

    companion object {
        private val types = values().associate { it.value to it }

        fun findByValue(value: Int) = types[value]
    }
}