package com.veronica.idn.pokemonapplication.data.local.db.variety

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = VarietyEntity.TABLE_NAME)
class VarietyEntity(
    @PrimaryKey
    @ColumnInfo(name = C_NAME) var name: String,
    var sprite: String
) {
    companion object {
        const val TABLE_NAME = "variety"
        const val C_NAME = "name"
    }
}