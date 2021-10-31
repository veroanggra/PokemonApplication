package com.veronica.idn.pokemonapplication.data.local.db.weakness

import androidx.room.Dao
import androidx.room.Query
import com.veronica.idn.pokemonapplication.data.local.base.BaseDao
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface WeaknessDao : BaseDao<WeaknessEntity> {
    @Query("select * from ${WeaknessEntity.TABLE_NAME}")
    fun getAll(): Single<List<WeaknessEntity>>

    @Query("delete from ${WeaknessEntity.TABLE_NAME}")
    fun clearTable(): Maybe<Int>
}