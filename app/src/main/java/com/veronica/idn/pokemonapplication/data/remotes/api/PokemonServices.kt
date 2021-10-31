package com.veronica.idn.pokemonapplication.data.remotes.api

import com.veronica.idn.pokemonapplication.data.remotes.response.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonServices {
    @GET("pokemon")
    fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Observable<PokemonResponse>

    @GET("pokemon/{name}")
    fun getPokemonDetail(@Path("name") pokemonName: String): Observable<PokemonDetailResponse>

    @GET("pokemon/{name}")
    fun getVarietySum(@Path("name") pokemonName: String): Observable<VarietySumResponse>

    @GET("pokemon-species/{name}")
    fun getSpeciesDetail(@Path("name") speciesName: String): Observable<SpeciesDetailResponse>

    @GET("ability/{name}")
    fun getAbilityDetail(@Path("name") abilityName: String): Observable<AbilityDetailResponse>

    @GET("type/{name}")
    fun getTypeDamages(@Path("name") typeName: String): Observable<TypeDamageResponse>

    @GET("evolution-chain/{id}")
    fun getEvolutionChain(@Path("id") evolutionChainId: Int): Observable<EvolutionChainResponse>

    @GET("type")
    fun getTypes(): Observable<TypesResponse>
}