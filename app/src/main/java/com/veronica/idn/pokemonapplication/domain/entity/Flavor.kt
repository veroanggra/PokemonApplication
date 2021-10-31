package com.veronica.idn.pokemonapplication.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Flavor(
    var text: String,
    var lang: String
) : Parcelable