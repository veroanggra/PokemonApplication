package com.veronica.idn.pokemonapplication.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.veronica.idn.pokemonapplication.BuildConfig
import com.veronica.idn.pokemonapplication.data.local.db.ability.AbilityDao
import com.veronica.idn.pokemonapplication.data.local.db.ability.AbilityEntity
import com.veronica.idn.pokemonapplication.data.local.db.evolution.EvolutionDao
import com.veronica.idn.pokemonapplication.data.local.db.evolution.EvolutionEntity
import com.veronica.idn.pokemonapplication.data.local.db.pokemon.PokemonDao
import com.veronica.idn.pokemonapplication.data.local.db.pokemon.PokemonEntity
import com.veronica.idn.pokemonapplication.data.local.db.pokemondetail.PokeSumDao
import com.veronica.idn.pokemonapplication.data.local.db.pokemondetail.PokemonDetailDao
import com.veronica.idn.pokemonapplication.data.local.db.pokemondetail.PokemonDetailEntity
import com.veronica.idn.pokemonapplication.data.local.db.pokemonsum.PokeSumEntity
import com.veronica.idn.pokemonapplication.data.local.db.stat.StatDao
import com.veronica.idn.pokemonapplication.data.local.db.stat.StatEntity
import com.veronica.idn.pokemonapplication.data.local.db.type.TypeDao
import com.veronica.idn.pokemonapplication.data.local.db.type.TypeEntity
import com.veronica.idn.pokemonapplication.data.local.db.variety.VarietyDao
import com.veronica.idn.pokemonapplication.data.local.db.variety.VarietyEntity
import com.veronica.idn.pokemonapplication.data.local.db.weakness.WeaknessDao
import com.veronica.idn.pokemonapplication.data.local.db.weakness.WeaknessEntity

@Database(
    version = AppDatabase.DB_VERSION,
    entities = [
        AbilityEntity::class,
        EvolutionEntity::class,
        PokemonEntity::class,
        PokemonDetailEntity::class,
        PokeSumEntity::class,
        StatEntity::class,
        TypeEntity::class,
        VarietyEntity::class,
        WeaknessEntity::class,
    ],
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun abilityDao(): AbilityDao
    abstract fun evolutionDao(): EvolutionDao
    abstract fun pokemonDao(): PokemonDao
    abstract fun pokeDetailDao(): PokemonDetailDao
    abstract fun pokeSumDao(): PokeSumDao
    abstract fun statDao(): StatDao
    abstract fun typeDao(): TypeDao
    abstract fun varietyDao(): VarietyDao
    abstract fun weaknessDao(): WeaknessDao

    companion object {
        const val DB_NAME = BuildConfig.FLAVOR + BuildConfig.BUILD_TYPE
        const val DB_VERSION = 1
    }

}