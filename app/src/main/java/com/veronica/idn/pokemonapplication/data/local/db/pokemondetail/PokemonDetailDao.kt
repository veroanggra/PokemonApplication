package com.veronica.idn.pokemonapplication.data.local.db.pokemondetail

import androidx.room.Dao
import androidx.room.Query
import com.veronica.idn.pokemonapplication.data.local.base.BaseDao
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface PokemonDetailDao : BaseDao<PokemonDetailEntity> {
    @Query("select * from ${PokemonDetailEntity.TABLE_NAME}")
    fun getAll(): Single<List<PokemonDetailEntity>>

    @Query("delete from ${PokemonDetailEntity.TABLE_NAME}")
    fun clearTable(): Maybe<Int>
}