package com.veronica.idn.pokemonapplication.data.local.base

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import io.reactivex.Completable

interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReplace(vararg objects: T): Completable

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertIgnore(vararg objects: T): Completable

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertAbort(vararg objects: T): Completable

    @Update
    fun update(vararg objects: T): Completable

    @Delete
    fun delete(vararg objects: T): Completable
}