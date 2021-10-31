package com.veronica.idn.pokemonapplication.data.repository

import com.veronica.idn.pokemonapplication.core.di.configuration.DataRemotes
import com.veronica.idn.pokemonapplication.core.di.configuration.LocalData
import com.veronica.idn.pokemonapplication.core.utils.RxScheduler
import com.veronica.idn.pokemonapplication.data.base.BaseRepository
import com.veronica.idn.pokemonapplication.domain.entity.PokemonDetail
import com.veronica.idn.pokemonapplication.domain.entity.PokemonSum
import com.veronica.idn.pokemonapplication.domain.entity.Variety
import com.veronica.idn.pokemonapplication.domain.repository.PokemonRepository
import io.reactivex.Observable
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject

class PokemonRepoFactory @Inject constructor(
    @LocalData localData: PokemonRepository.DataSource,
    @DataRemotes remoteData: PokemonRepository.DataSource,
    private val scheduler: RxScheduler
) :
    BaseRepository<PokemonRepository.DataSource>(localData, remoteData), PokemonRepository {
    override fun getPokemonList(): Single<List<PokemonSum>> {
        return if (remoteDataSourceEmpty()) {
            Single.error(IllegalArgumentException())
        } else {
            remoteData!!.getPokemonList()
        }
    }

    override fun getPokemonDetail(pokemonName: String, speciesName: String)
            : Observable<PokemonDetail> {
        return if (remoteDataSourceEmpty()) {
            Observable.error(IllegalArgumentException())
        } else {
            remoteData!!.getPokemonDetail(pokemonName, speciesName)
        }
    }

    override fun getVarietySums(names: List<String>): Single<List<Variety>> {
        return if (remoteDataSourceEmpty()) {
            Single.error(IllegalArgumentException())
        } else {
            remoteData!!.getVarietySums(names)
        }
    }

}