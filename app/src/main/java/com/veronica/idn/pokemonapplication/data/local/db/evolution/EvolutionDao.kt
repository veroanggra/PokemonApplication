package com.veronica.idn.pokemonapplication.data.local.db.evolution

import androidx.room.Dao
import androidx.room.Query
import com.veronica.idn.pokemonapplication.data.local.base.BaseDao
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface EvolutionDao : BaseDao<EvolutionEntity> {
    @Query("select * from ${EvolutionEntity.TABLE_NAME} where ${EvolutionEntity.CHAIN}=:chainId")
    fun getAll(chainId: Int): Single<List<EvolutionEntity>>

    @Query("delete from ${EvolutionEntity.TABLE_NAME}")
    fun clearTable(): Maybe<Int>
}