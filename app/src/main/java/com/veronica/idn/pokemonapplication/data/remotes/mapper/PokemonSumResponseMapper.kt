package com.veronica.idn.pokemonapplication.data.remotes.mapper


import com.veronica.idn.pokemonapplication.R
import com.veronica.idn.pokemonapplication.core.utils.DataConverter
import com.veronica.idn.pokemonapplication.data.base.DataMapper
import com.veronica.idn.pokemonapplication.data.remotes.response.PokemonDetailResponse
import com.veronica.idn.pokemonapplication.domain.entity.PokemonSum
import com.veronica.idn.pokemonapplication.domain.entity.Type
import javax.inject.Inject

class PokemonSumResponseMapper @Inject internal constructor(private val converter: DataConverter) :
    DataMapper<PokemonDetailResponse?, PokemonSum> {
    override fun fromData(data: PokemonSum): PokemonDetailResponse? {
        return null
    }

    override fun toData(source: PokemonDetailResponse?): PokemonSum {
        if (source == null) {
            throw UnsupportedOperationException()
        }
        val types: ArrayList<Type> = arrayListOf()
        source.types?.map {
            val name = it.type?.name.orEmpty()
            val tagRes = converter.getResourceId("${name}_tag", R.mipmap::class.java)
            val typeRes = converter.getResourceId("${name}_type", R.mipmap::class.java)
            val t = Type(name, tagRes, typeRes)
            types.add(t)
        }
        val name = source.name.orEmpty()
        val default = source.sprites?.frontDefault.orEmpty()
        val shiny = source.sprites?.frontShiny.orEmpty()
        val official = source.sprites?.other?.officialArtwork?.frontDefault.orEmpty()
        val dreamWorld = source.sprites?.other?.dreamWorld?.frontDefault.orEmpty()
        val sprite = if (official.isEmpty()) default else official
        val spriteShiny = if (dreamWorld.isEmpty()) shiny else dreamWorld
        val spName = source.species?.name.orEmpty()
        return PokemonSum(source.id, name, sprite, spriteShiny, spName, types)
    }
}