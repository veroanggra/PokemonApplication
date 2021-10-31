package com.veronica.idn.pokemonapplication.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Variety(
    var name: String,
    var sprite: String
) : Parcelable