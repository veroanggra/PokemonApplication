package com.veronica.idn.pokemonapplication.data.local.mapper


import com.veronica.idn.pokemonapplication.data.base.DataMapper
import com.veronica.idn.pokemonapplication.data.local.db.variety.VarietyEntity
import com.veronica.idn.pokemonapplication.domain.entity.Variety
import javax.inject.Inject

class VarietyEntityMapper @Inject internal constructor() : DataMapper<VarietyEntity, Variety> {
    override fun fromData(data: Variety) = VarietyEntity(data.name, data.sprite)
    override fun toData(source: VarietyEntity) = Variety(source.name, source.sprite)
}