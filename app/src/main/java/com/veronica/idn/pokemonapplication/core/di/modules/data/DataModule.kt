package com.veronica.idn.pokemonapplication.core.di.modules.data

import com.veronica.idn.pokemonapplication.data.repository.PokemonRepoFactory
import com.veronica.idn.pokemonapplication.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module

@Module(includes = [LocalDataModule::class, RemoteDataModule::class])
internal abstract class DataModule {
    @Binds
    abstract fun pokemonRepository(pokemonRepoFactory: PokemonRepoFactory): PokemonRepository
}