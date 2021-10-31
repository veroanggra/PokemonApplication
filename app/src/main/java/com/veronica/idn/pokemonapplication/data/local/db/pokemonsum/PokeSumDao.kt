package com.veronica.idn.pokemonapplication.data.local.db.pokemondetail

import androidx.room.Dao
import androidx.room.Query
import com.veronica.idn.pokemonapplication.data.local.base.BaseDao
import com.veronica.idn.pokemonapplication.data.local.db.pokemonsum.PokeSumEntity
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface PokeSumDao : BaseDao<PokeSumEntity> {
    @Query("select * from ${PokeSumEntity.TABLE_NAME}")
    fun getPokemonSum(): Single<List<PokeSumEntity>>


    @Query("delete from ${PokeSumEntity.TABLE_NAME}")
    fun clearTable(): Maybe<Int>
}