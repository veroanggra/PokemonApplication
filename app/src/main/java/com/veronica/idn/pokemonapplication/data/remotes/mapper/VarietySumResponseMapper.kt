package com.veronica.idn.pokemonapplication.data.remotes.mapper


import com.veronica.idn.pokemonapplication.data.base.DataMapper
import com.veronica.idn.pokemonapplication.data.remotes.response.VarietySumResponse
import com.veronica.idn.pokemonapplication.domain.entity.Variety
import javax.inject.Inject

class VarietySumResponseMapper @Inject internal constructor() :
    DataMapper<VarietySumResponse?, Variety> {
    override fun fromData(data: Variety): VarietySumResponse? {
        return null
    }

    override fun toData(source: VarietySumResponse?): Variety {
        if (source == null) {
            throw UnsupportedOperationException()
        }
        val name = source.name.orEmpty()
        val default = source.sprites?.frontDefault.orEmpty()
        val official = source.sprites?.other?.officialArtwork?.frontDefault.orEmpty()
        val sprite = if (official.isEmpty()) default else official
        return Variety(name, sprite)
    }
}