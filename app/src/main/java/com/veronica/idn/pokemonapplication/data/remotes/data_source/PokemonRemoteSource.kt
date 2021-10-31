package com.veronica.idn.pokemonapplication.data.remotes.data_source


import com.veronica.idn.pokemonapplication.data.remotes.api.PokemonServices
import com.veronica.idn.pokemonapplication.data.remotes.mapper.PokemonDetailResponseMapper
import com.veronica.idn.pokemonapplication.data.remotes.mapper.PokemonSumResponseMapper
import com.veronica.idn.pokemonapplication.data.remotes.mapper.VarietySumResponseMapper
import com.veronica.idn.pokemonapplication.data.remotes.response.*
import com.veronica.idn.pokemonapplication.domain.entity.PokemonDetail
import com.veronica.idn.pokemonapplication.domain.entity.PokemonSum
import com.veronica.idn.pokemonapplication.domain.entity.Variety
import com.veronica.idn.pokemonapplication.domain.repository.PokemonRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class PokemonRemoteSource @Inject internal constructor(
    private val pokemonServices: PokemonServices,
    private val sumMapper: PokemonSumResponseMapper,
    private val detailMapper: PokemonDetailResponseMapper,
    private val spSumMapper: VarietySumResponseMapper,
) : PokemonRepository.DataSource {
    override fun persistDetailPokemon(pokemonDetail: PokemonDetail): Completable {
        return Completable.error(UnsupportedOperationException())
    }

    override fun persistVariety(variety: Variety): Completable {
        TODO("Not yet implemented")
    }

    override fun persistPokemonSum(pokemonSum: PokemonSum): Completable {
        TODO("Not yet implemented")
    }

    override fun getPokemonList(): Single<List<PokemonSum>> {
        return pokemonServices.getPokemonList(limit = 20, offset = 0)
            .filter { !it.results.isNullOrEmpty() }
            .map { it.results }
            .flatMapIterable { pokes -> pokes }
            .flatMap { pokemonServices.getPokemonDetail(it.name.orEmpty()) }
            .map { sumMapper.toData(it) }
            .toList()
    }

    override fun getPokemonDetail(pokemonName: String, speciesName: String)
            : Observable<PokemonDetail> {
        return Observable.zip(
            pokemonServices.getPokemonDetail(pokemonName),
            pokemonServices.getSpeciesDetail(speciesName)
        ) { pokemon, species -> Pair(pokemon, species) }
            .flatMap { pair ->
                Observable.zip(
                    Observable.just(pair.first),
                    Observable.just(pair.second),
                    getAbilities(pair.first),
                    getTypeDamages(pair.first),
                    getEvolutions(pair.second),
                    pokemonServices.getTypes()
                ) { p, s, a, d, e, t ->
                    detailMapper.toData(PokemonDetailResponsesComposer(p, s, a, d, e, t))
                }
            }
    }

    override fun getVarietySums(names: List<String>): Single<List<Variety>> {
        return Observable.just(names)
            .flatMapIterable { arr -> arr }
            .flatMap { pokemonServices.getVarietySum(it) }
            .map { spSumMapper.toData(it) }
            .toList()

    }

    private fun getAbilities(pokemonResponse: PokemonDetailResponse): Observable<List<AbilityDetailResponse>> {
        return Observable.fromArray(pokemonResponse.abilities)
            .flatMapIterable { abilities -> abilities }
            .flatMap { pokemonServices.getAbilityDetail(it.ability?.name.orEmpty()) }
            .toList()
            .toObservable()
    }

    private fun getTypeDamages(pokemonResponse: PokemonDetailResponse): Observable<List<TypeDamageResponse>> {
        return Observable.fromArray(pokemonResponse.types)
            .flatMapIterable { types -> types }
            .flatMap { pokemonServices.getTypeDamages(it.type?.name.orEmpty()) }
            .toList()
            .toObservable()
    }

    private fun getEvolutions(speciesResponse: SpeciesDetailResponse): Observable<EvolutionChainResponse> {
        val evolutionUrl = speciesResponse.evolutionChain!!.url
        val evolutionIdString =
            evolutionUrl?.substringAfterLast("/evolution-chain/")?.filter { it.isDigit() }
        val evoId: Int = evolutionIdString?.toInt() ?: 0
        return pokemonServices.getEvolutionChain(evoId)
    }

}