package com.veronica.idn.pokemonapplication.presentation.evolution

import com.veronica.idn.pokemonapplication.domain.entity.Variety
import com.veronica.idn.pokemonapplication.presentation.base.PresentationInterface


interface EvolutionsInterface {
    interface View : PresentationInterface.View {
        fun showVarietySums(spSums: List<Variety>)
    }

    interface Presenter<V : View> : PresentationInterface.Presenter<V> {
        fun getVarietySums(names: List<String>)
    }
}