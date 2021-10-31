package com.veronica.idn.pokemonapplication.domain.usecase

import com.veronica.idn.pokemonapplication.domain.base.UseCase
import com.veronica.idn.pokemonapplication.domain.entity.Variety
import com.veronica.idn.pokemonapplication.domain.repository.PokemonRepository
import io.reactivex.Single
import javax.inject.Inject

class GetVarietySumList @Inject internal constructor(private val pokemonRepository: PokemonRepository) :
    UseCase<Single<List<Variety>>, List<String>> {

    override fun execute(param: List<String>): Single<List<Variety>> {
        return pokemonRepository.getVarietySums(param)
    }
}