package com.veronica.idn.pokemonapplication.data.remotes.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TypeDamageResponse {
    @SerializedName("damage_relations")
    @Expose
    var damageRelations: DamageRelations? = null

    @SerializedName("id")
    @Expose
    var id = 0

    @SerializedName("name")
    @Expose
    var name: String? = null
}

class DamageRelations {
    @SerializedName("double_damage_from")
    @Expose
    var doubleDamageFrom: List<NameUrlResponse>? = null

    @SerializedName("double_damage_to")
    @Expose
    var doubleDamageTo: List<NameUrlResponse>? = null

    @SerializedName("half_damage_from")
    @Expose
    var halfDamageFrom: List<NameUrlResponse>? = null

    @SerializedName("half_damage_to")
    @Expose
    var halfDamageTo: List<NameUrlResponse>? = null

    @SerializedName("no_damage_from")
    @Expose
    var noDamageFrom: List<NameUrlResponse>? = null

    @SerializedName("no_damage_to")
    @Expose
    var noDamageTo: List<NameUrlResponse>? = null
}