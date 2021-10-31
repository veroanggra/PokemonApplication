package com.veronica.idn.pokemonapplication.data.local.mapper

import com.veronica.idn.pokemonapplication.data.base.DataMapper
import com.veronica.idn.pokemonapplication.data.local.db.weakness.WeaknessEntity
import com.veronica.idn.pokemonapplication.domain.entity.Type
import com.veronica.idn.pokemonapplication.domain.entity.Weakness
import javax.inject.Inject

class WeaknessEntityMapper @Inject internal constructor() : DataMapper<WeaknessEntity, Weakness> {
    override fun fromData(data: Weakness) = WeaknessEntity(
        data.pokemonId,
        data.type.name,
        data.type.tagRes,
        data.type.typeRes,
        data.multiplier
    )

    override fun toData(source: WeaknessEntity): Weakness {
        val type = Type(source.typeName, source.tagRes, source.typeRes)
        return Weakness(source.pokemonId, type, source.multiplier)
    }
}