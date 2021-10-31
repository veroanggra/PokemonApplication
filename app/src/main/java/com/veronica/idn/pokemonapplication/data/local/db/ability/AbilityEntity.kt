package com.veronica.idn.pokemonapplication.data.local.db.ability

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = AbilityEntity.TABLE_NAME)
class AbilityEntity(
    @PrimaryKey
    @ColumnInfo(name = ID) var id: Int,
    var name: String,
    var effect: String,
    var shortEffect: String,
    var flavorText: String,
    var slot: Int,
    var isHidden: Boolean
) {
    companion object {
        const val TABLE_NAME = "ability"
        const val ID = "id"
    }
}