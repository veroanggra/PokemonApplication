package com.veronica.idn.pokemonapplication.core.di.modules.data

import com.veronica.idn.pokemonapplication.core.di.configuration.DataRemotes
import com.veronica.idn.pokemonapplication.data.remotes.data_source.PokemonRemoteSource
import com.veronica.idn.pokemonapplication.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module

@Module
internal abstract class RemoteDataSourceModule {
    @Binds
    @DataRemotes
    abstract fun pokemonDataSource(remoteAuthSource: PokemonRemoteSource): PokemonRepository.DataSource
}