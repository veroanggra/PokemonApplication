package com.veronica.idn.pokemonapplication.data.local.db.type

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TypeEntity.TABLE_NAME)
class TypeEntity(
    @PrimaryKey
    @ColumnInfo(name = NAME) var name: String,
    @ColumnInfo(name = TAG_R) var tagRes: Int,
    @ColumnInfo(name = TYPE_R) var typeRes: Int
) {
    companion object {
        const val TABLE_NAME = "type"
        const val NAME = "typeName"
        const val TAG_R = "tagRes"
        const val TYPE_R = "typeRes"
    }
}