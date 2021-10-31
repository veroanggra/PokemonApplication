package com.veronica.idn.pokemonapplication.data.local.source

import com.veronica.idn.pokemonapplication.data.local.db.AppDatabase
import com.veronica.idn.pokemonapplication.data.local.mapper.VarietyEntityMapper
import com.veronica.idn.pokemonapplication.domain.entity.PokemonDetail
import com.veronica.idn.pokemonapplication.domain.entity.PokemonSum
import com.veronica.idn.pokemonapplication.domain.entity.Variety
import com.veronica.idn.pokemonapplication.domain.repository.PokemonRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class PokemonLocalSource @Inject internal constructor(
    private val db: AppDatabase,
    private val varietyMapper: VarietyEntityMapper
) : PokemonRepository.DataSource {
    override fun persistDetailPokemon(pokemonDetail: PokemonDetail): Completable {
        return Completable.never()

    }

    override fun persistVariety(variety: Variety): Completable {
        return db.varietyDao().insertReplace(varietyMapper.fromData(variety))
    }

    override fun persistPokemonSum(pokemonSum: PokemonSum): Completable {
        TODO("Not yet implemented")
    }

    override fun getPokemonList(): Single<List<PokemonSum>> {
        return Single.error(UnsupportedOperationException())
    }

    override fun getPokemonDetail(pokemonName: String, speciesName: String)
            : Observable<PokemonDetail> {
        return Observable.error(UnsupportedOperationException())
    }

    override fun getVarietySums(names: List<String>): Single<List<Variety>> {
        return Observable.just(names)
            .flatMapIterable { arr -> arr }
            .flatMap { db.varietyDao().getAll(it).toObservable() }
            .flatMapIterable { sums -> sums }
            .map { varietyMapper.toData(it) }
            .toList()
    }

}