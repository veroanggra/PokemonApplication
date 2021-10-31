package com.veronica.idn.pokemonapplication.core.di.modules.view


import com.veronica.idn.pokemonapplication.presentation.main.MainActivity
import com.veronica.idn.pokemonapplication.presentation.main.MainInterface
import com.veronica.idn.pokemonapplication.presentation.main.MainPresenter
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @Binds
    abstract fun mainPresenter(mainPresenter: MainPresenter<MainInterface.View>): MainInterface.Presenter<MainInterface.View>
}