package com.veronica.idn.pokemonapplication.presentation.home

import com.veronica.idn.pokemonapplication.domain.entity.PokemonSum
import com.veronica.idn.pokemonapplication.presentation.base.PresentationInterface


interface HomeInterface {
    interface View : PresentationInterface.View {
        fun showPokemonList(items: List<PokemonSum>)
    }


    interface Presenter<V : View> : PresentationInterface.Presenter<V> {
        fun getPokemonList()
    }
}