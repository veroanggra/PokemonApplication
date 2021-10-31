package com.veronica.idn.pokemonapplication.presentation.main

import com.veronica.idn.pokemonapplication.presentation.base.PresentationInterface


interface MainInterface {
    interface View : PresentationInterface.View

    interface Presenter<V : View> : PresentationInterface.Presenter<V>
}