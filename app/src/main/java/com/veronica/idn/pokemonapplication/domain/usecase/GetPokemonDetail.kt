package com.veronica.idn.pokemonapplication.domain.usecase


import com.veronica.idn.pokemonapplication.domain.base.UseCase
import com.veronica.idn.pokemonapplication.domain.entity.PokemonDetail
import com.veronica.idn.pokemonapplication.domain.params.PokemonDetailParam
import com.veronica.idn.pokemonapplication.domain.repository.PokemonRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetPokemonDetail @Inject internal constructor(private val pokemonRepository: PokemonRepository) :
    UseCase<Observable<PokemonDetail>, PokemonDetailParam> {

    override fun execute(param: PokemonDetailParam): Observable<PokemonDetail> {
        return pokemonRepository.getPokemonDetail(param.pokemonName, param.speciesName)
    }
}