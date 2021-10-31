package com.veronica.idn.pokemonapplication.data.remotes.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EvolutionChainResponse {
    @SerializedName("chain")
    @Expose
    var chain: Chain? = null

    @SerializedName("id")
    @Expose
    var id = 0
}

class Chain {
    @SerializedName("evolution_details")
    @Expose
    var evolutionDetails: List<EvolutionDetailResponse>? = null

    @SerializedName("evolves_to")
    @Expose
    var evolvesTo: List<Chain>? = null

    @SerializedName("is_baby")
    @Expose
    var isBaby = false

    @SerializedName("species")
    @Expose
    var species: NameUrlResponse? = null
}

class EvolutionDetailResponse {
    @SerializedName("gender")
    @Expose
    var gender: Int? = null

    @SerializedName("held_item")
    @Expose
    var heldItem: NameUrlResponse? = null

    @SerializedName("item")
    @Expose
    var item: NameUrlResponse? = null

    @SerializedName("known_move")
    @Expose
    var knownMove: NameUrlResponse? = null

    @SerializedName("known_move_type")
    @Expose
    var knownMoveType: NameUrlResponse? = null

    @SerializedName("location")
    @Expose
    var location: NameUrlResponse? = null

    @SerializedName("min_affection")
    @Expose
    var minAffection: Int? = null

    @SerializedName("min_beauty")
    @Expose
    var minBeauty: Int? = null

    @SerializedName("min_happiness")
    @Expose
    var minHappiness: Int? = null

    @SerializedName("min_level")
    @Expose
    var minLevel: Int? = null

    @SerializedName("needs_overworld_rain")
    @Expose
    var needsOverworldRain = false

    @SerializedName("party_species")
    @Expose
    var partySpecies: NameUrlResponse? = null

    @SerializedName("party_type")
    @Expose
    var partyType: NameUrlResponse? = null

    @SerializedName("relative_physical_stats")
    @Expose
    var relativePhysicalStats: Int? = null

    @SerializedName("time_of_day")
    @Expose
    var timeOfDay: String? = null

    @SerializedName("trade_species")
    @Expose
    var tradeSpecies: NameUrlResponse? = null

    @SerializedName("trigger")
    @Expose
    var trigger: NameUrlResponse? = null

    @SerializedName("turn_upside_down")
    @Expose
    var turnUpsideDown = false
}