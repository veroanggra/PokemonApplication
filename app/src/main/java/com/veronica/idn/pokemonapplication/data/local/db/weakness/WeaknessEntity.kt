package com.veronica.idn.pokemonapplication.data.local.db.weakness

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = WeaknessEntity.TABLE_NAME)
class WeaknessEntity(
    @ColumnInfo(name = C_POKE_ID) var pokemonId: Int,
    var typeName: String,
    var tagRes: Int,
    var typeRes: Int,
    var multiplier: Double

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    companion object {
        const val TABLE_NAME = "weakness"
        const val C_POKE_ID = "pokemonId"

    }
}