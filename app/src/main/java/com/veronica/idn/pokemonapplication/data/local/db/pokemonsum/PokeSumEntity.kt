package com.veronica.idn.pokemonapplication.data.local.db.pokemonsum

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.veronica.idn.pokemonapplication.data.local.db.pokemon.PokemonEntity
import com.veronica.idn.pokemonapplication.data.local.db.type.TypeEntity

@Entity(
    tableName = PokeSumEntity.TABLE_NAME,
    primaryKeys = [PokemonEntity.NAME, TypeEntity.NAME],
)
class PokeSumEntity(
    @ColumnInfo(name = PokemonEntity.NAME)
    val pokemonName: String,
    @ColumnInfo(name = TypeEntity.NAME)
    val typeName: String
) {

    companion object {
        const val TABLE_NAME = "pokemonSum"
    }
}