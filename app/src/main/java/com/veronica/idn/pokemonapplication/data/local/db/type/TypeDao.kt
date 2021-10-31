package com.veronica.idn.pokemonapplication.data.local.db.type

import androidx.room.Dao
import androidx.room.Query
import com.veronica.idn.pokemonapplication.data.local.base.BaseDao
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface TypeDao : BaseDao<TypeEntity> {
    @Query("select * from ${TypeEntity.TABLE_NAME}")
    fun getAll(): Single<List<TypeEntity>>

    @Query("delete from ${TypeEntity.TABLE_NAME}")
    fun clearTable(): Maybe<Int>
}