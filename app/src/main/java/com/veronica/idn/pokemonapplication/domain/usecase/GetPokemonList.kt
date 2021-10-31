package com.veronica.idn.pokemonapplication.domain.usecase

import com.veronica.idn.pokemonapplication.domain.base.UseCase
import com.veronica.idn.pokemonapplication.domain.entity.PokemonSum
import com.veronica.idn.pokemonapplication.domain.repository.PokemonRepository
import io.reactivex.Single
import javax.inject.Inject

class GetPokemonList @Inject internal constructor(private val pokemonRepository: PokemonRepository) :
    UseCase<Single<List<PokemonSum>>, Void?> {

    override fun execute(param: Void?): Single<List<PokemonSum>> {
        return pokemonRepository.getPokemonList()
    }
}