package com.veronica.idn.pokemonapplication.data.remotes.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SpeciesDetailResponse {
    @SerializedName("base_happiness")
    @Expose
    var baseHappiness = 0

    @SerializedName("capture_rate")
    @Expose
    var captureRate = 0

    @SerializedName("color")
    @Expose
    var color: NameUrlResponse? = null

    @SerializedName("egg_groups")
    @Expose
    var eggGroups: List<NameUrlResponse>? = null

    @SerializedName("evolution_chain")
    @Expose
    var evolutionChain: EvolutionChain? = null

    @SerializedName("flavor_text_entries")
    @Expose
    var flavorTextEntries: List<FlavorTextEntry>? = null

    @SerializedName("gender_rate")
    @Expose
    var genderRate = 0

    @SerializedName("generation")
    @Expose
    var generation: NameUrlResponse? = null

    @SerializedName("habitat")
    @Expose
    var habitat: NameUrlResponse? = null

    @SerializedName("has_gender_differences")
    @Expose
    var hasGenderDifferences = false

    @SerializedName("hatch_counter")
    @Expose
    var hatchCounter = 0

    @SerializedName("id")
    @Expose
    var id = 0

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("shape")
    @Expose
    var shape: NameUrlResponse? = null
}

class EvolutionChain {
    @SerializedName("url")
    @Expose
    var url: String? = null
}