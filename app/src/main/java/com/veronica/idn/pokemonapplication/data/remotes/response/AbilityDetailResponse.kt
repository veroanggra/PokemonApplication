package com.veronica.idn.pokemonapplication.data.remotes.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class AbilityDetailResponse {
    @SerializedName("effect_entries")
    @Expose
    var effectEntries: List<EffectEntry>? = null

    @SerializedName("flavor_text_entries")
    @Expose
    var flavorTextEntries: List<FlavorTextEntry>? = null

    @SerializedName("id")
    @Expose
    var id = 0

    @SerializedName("name")
    @Expose
    var name: String? = null
}

class EffectEntry {
    @SerializedName("effect")
    @Expose
    var effect: String? = null

    @SerializedName("language")
    @Expose
    var language: NameUrlResponse? = null

    @SerializedName("short_effect")
    @Expose
    var shortEffect: String? = null
}

