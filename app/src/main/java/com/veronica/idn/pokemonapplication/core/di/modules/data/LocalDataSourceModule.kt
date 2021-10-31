package com.veronica.idn.pokemonapplication.core.di.modules.data

import com.veronica.idn.pokemonapplication.core.di.configuration.LocalData
import com.veronica.idn.pokemonapplication.data.local.source.PokemonLocalSource
import com.veronica.idn.pokemonapplication.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module

@Module
internal abstract class LocalDataSourceModule {
    @Binds
    @LocalData
    abstract fun pokemonDataSource(pokemonLocalSource: PokemonLocalSource): PokemonRepository.DataSource

}