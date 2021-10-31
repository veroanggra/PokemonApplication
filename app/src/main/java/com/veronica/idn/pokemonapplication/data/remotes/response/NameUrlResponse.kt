package com.veronica.idn.pokemonapplication.data.remotes.response

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class NameUrlResponse {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null
}