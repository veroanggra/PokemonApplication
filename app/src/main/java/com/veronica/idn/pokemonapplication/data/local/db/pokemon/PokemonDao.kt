package com.veronica.idn.pokemonapplication.data.local.db.pokemon

import androidx.room.Dao
import androidx.room.Query
import com.veronica.idn.pokemonapplication.data.local.base.BaseDao
import com.veronica.idn.pokemonapplication.data.local.db.pokemondetail.PokemonDetailEntity
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface PokemonDao : BaseDao<PokemonDetailEntity> {
    @Query("select * from ${PokemonEntity.TABLE_NAME}")
    fun getAll(): Single<List<PokemonDetailEntity>>

    @Query("delete from ${PokemonEntity.TABLE_NAME}")
    fun clearTable(): Maybe<Int>
}