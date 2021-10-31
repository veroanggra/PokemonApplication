package com.veronica.idn.pokemonapplication.data.remotes.response

data class PokemonDetailResponsesComposer(
    val pokemon: PokemonDetailResponse,
    val species: SpeciesDetailResponse,
    val abilities: List<AbilityDetailResponse>,
    val typeDamages: List<TypeDamageResponse>,
    val evolution: EvolutionChainResponse,
    val types: TypesResponse
)
