package com.veronica.idn.pokemonapplication.core.di.modules.data

import com.veronica.idn.pokemonapplication.core.di.components.ApplicationScope
import com.veronica.idn.pokemonapplication.data.remotes.api.PokemonServices
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class NetworkModule {
    @ApplicationScope
    @Provides
    fun pokemonApi(retrofit: Retrofit): PokemonServices {
        return retrofit.create(PokemonServices::class.java)
    }

}