package com.veronica.idn.pokemonapplication.data.local.db.stat

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = StatEntity.TABLE_NAME)
class StatEntity(
    @PrimaryKey
    @ColumnInfo(name = NAME) var name: String,
    var base: Int,
    var effort: Int
) {
    companion object {
        const val TABLE_NAME = "stat"
        const val NAME = "statName"
    }
}