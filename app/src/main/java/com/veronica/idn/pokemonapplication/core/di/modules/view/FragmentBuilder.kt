package com.veronica.idn.pokemonapplication.core.di.modules.view

import com.veronica.idn.pokemonapplication.presentation.detail.DetailFragment
import com.veronica.idn.pokemonapplication.presentation.home.HomeFragment
import com.veronica.idn.pokemonapplication.presentation.home.HomeInterface
import com.veronica.idn.pokemonapplication.presentation.home.HomePresenter
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class FragmentBuilder {
    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment

    @Binds
    abstract fun pokemonListPresenter(homePresenter: HomePresenter<HomeInterface.View>): HomeInterface.Presenter<HomeInterface.View>

    @ContributesAndroidInjector
    abstract fun detailFragment(): DetailFragment
//
//    @Binds
//    abstract fun pokemonDetailPresenter(pokemonInfoPresenter: PokemonInfoPresenter<PokemonInfo.View>): PokemonInfo.Presenter<PokemonInfo.View>
//
//    @ContributesAndroidInjector
//    abstract fun statsFragment(): StatsFragment
//
//    @ContributesAndroidInjector
//    abstract fun evolutionsFragment(): EvolutionsFragment
//
//    @Binds
//    abstract fun evolutionsPresenter(pokemonEvolutionsPresenter: PokemonEvolutionsPresenter<PokemonEvolutions.View>): PokemonEvolutions.Presenter<PokemonEvolutions.View>

}
