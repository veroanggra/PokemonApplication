package com.veronica.idn.pokemonapplication.data.remotes.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PokemonDetailResponse {
    @SerializedName("abilities")
    @Expose
    var abilities: List<AbilityResponse>? = null

    @SerializedName("height")
    @Expose
    var height = 0

    @SerializedName("id")
    @Expose
    var id = 0

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("species")
    @Expose
    var species: NameUrlResponse? = null

    @SerializedName("sprites")
    @Expose
    var sprites: Sprites? = null

    @SerializedName("stats")
    @Expose
    var stats: List<Stat>? = null

    @SerializedName("types")
    @Expose
    var types: List<TypeResponse>? = null

    @SerializedName("weight")
    @Expose
    var weight = 0

}

class AbilityResponse {
    @SerializedName("ability")
    @Expose
    var ability: NameUrlResponse? = null

    @SerializedName("is_hidden")
    @Expose
    var isHidden = false

    @SerializedName("slot")
    @Expose
    var slot = 0

}

class DreamWorld {
    @SerializedName("front_default")
    @Expose
    var frontDefault: String? = null

    @SerializedName("front_female")
    @Expose
    var frontFemale: String? = null
}

class OfficialArtwork {
    @SerializedName("front_default")
    @Expose
    var frontDefault: String? = null

}

class Other {
    @SerializedName("dream_world")
    @Expose
    var dreamWorld: DreamWorld? = null

    @SerializedName("official-artwork")
    @Expose
    var officialArtwork: OfficialArtwork? = null

}

class Sprites {
    @SerializedName("back_default")
    @Expose
    var backDefault: String? = null

    @SerializedName("back_female")
    @Expose
    var backFemale: String? = null

    @SerializedName("back_shiny")
    @Expose
    var backShiny: String? = null

    @SerializedName("back_shiny_female")
    @Expose
    var backShinyFemale: String? = null

    @SerializedName("front_default")
    @Expose
    var frontDefault: String? = null

    @SerializedName("front_female")
    @Expose
    var frontFemale: String? = null

    @SerializedName("front_shiny")
    @Expose
    var frontShiny: String? = null

    @SerializedName("front_shiny_female")
    @Expose
    var frontShinyFemale: String? = null

    @SerializedName("other")
    @Expose
    var other: Other? = null

}


class Stat {
    @SerializedName("base_stat")
    @Expose
    var baseStat = 0

    @SerializedName("effort")
    @Expose
    var effort = 0

    @SerializedName("stat")
    @Expose
    var stat: NameUrlResponse? = null

}


class TypeResponse {
    @SerializedName("slot")
    @Expose
    var slot = 0

    @SerializedName("type")
    @Expose
    var type: NameUrlResponse? = null

}