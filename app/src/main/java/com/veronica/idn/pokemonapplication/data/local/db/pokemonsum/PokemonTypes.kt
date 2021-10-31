package com.veronica.idn.pokemonapplication.data.local.db.pokemonsum

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.veronica.idn.pokemonapplication.data.local.db.pokemon.PokemonEntity
import com.veronica.idn.pokemonapplication.data.local.db.pokemondetail.PokemonDetailEntity
import com.veronica.idn.pokemonapplication.data.local.db.pokemonsum.PokeSumEntity
import com.veronica.idn.pokemonapplication.data.local.db.type.TypeEntity

data class PokemonTypes(
    @Embedded
    val pokemon: PokemonDetailEntity,

    @Relation(
        parentColumn = PokemonEntity.NAME,
        entityColumn = TypeEntity.NAME,
        associateBy = Junction(PokeSumEntity::class)
    )
    val types: List<TypeEntity>
)