package com.veronica.idn.pokemonapplication.data.local.db.pokemondetail

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = PokemonDetailEntity.TABLE_NAME)
class PokemonDetailEntity(
    @PrimaryKey
    @ColumnInfo(name = NAME) var name: String,
    @ColumnInfo(name = SP_NAME) var speciesName: String,
    @ColumnInfo(name = SPRITE) var sprite: String,
    var spriteShiny: String
) {
    companion object {
        const val TABLE_NAME = "pokemonDetail"
        const val NAME = "pokemonName"
        const val SP_NAME = "spName"
        const val SPRITE = "sprite"
    }
}