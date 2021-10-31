package com.veronica.idn.pokemonapplication.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weakness(
    var pokemonId: Int,
    var type: Type,
    var multiplier: Double
) : Parcelable {
    fun multiplierLabel(): String {
        return if (multiplier >= 0) {
            multiplier.toString()
        } else {
            "1/${1 / multiplier}"
        }.replace(".0", "").plus(" x")
    }
}