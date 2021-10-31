package com.veronica.idn.pokemonapplication.data.remotes.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class VarietySumResponse {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("sprites")
    @Expose
    var sprites: SpriteFront? = null

}

class SpriteFront {

    @SerializedName("front_default")
    @Expose
    var frontDefault: String? = null

    @SerializedName("other")
    @Expose
    var other: Other? = null

}