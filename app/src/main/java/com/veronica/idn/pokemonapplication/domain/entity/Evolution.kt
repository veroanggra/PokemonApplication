package com.veronica.idn.pokemonapplication.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Evolution(
    var chainId: Int,
    var fromName: String,
    var fromSprite: String,
    var toName: String,
    var toSprite: String,
    var trigger: String,
    var triggerSpecs: String
) : Parcelable