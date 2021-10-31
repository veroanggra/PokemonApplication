package com.veronica.idn.pokemonapplication.presentation.detail


import com.veronica.idn.pokemonapplication.domain.entity.PokemonDetail
import com.veronica.idn.pokemonapplication.presentation.base.PresentationInterface


interface DetailInterface {
    interface View : PresentationInterface.View {
        fun showDetail(detail: PokemonDetail)
    }

    interface Presenter<V : View> : PresentationInterface.Presenter<V> {
        fun getPokemonDetail(pokemonName: String, speciesName: String)
    }
}