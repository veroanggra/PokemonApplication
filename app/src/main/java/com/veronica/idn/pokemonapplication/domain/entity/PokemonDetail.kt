package com.veronica.idn.pokemonapplication.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonDetail(
    // variety fields
    var id: Int,
    var name: String,
    var sprite: String,
    var spriteShiny: String,
    var types: List<Type>,
    var stats: List<Stat>,
    var abilities: List<Ability>,
    var weaknesses: List<Weakness>,

    // species fields
    var speciesId: Int,
    var speciesName: String,
    var color: String,
    var flavor: Flavor,
    var eggGroups: List<String>,
    var hatchCycles: Int,
    var hatchSteps: Int,
    var femaleRatio: Int,
    var femalePercent: Double,
    var malePercent: Double,
    var habitat: String,
    var generation: String,
    var captureRate: Int,
    var evolutions: List<Evolution>
) : Parcelable