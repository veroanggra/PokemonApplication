package com.veronica.idn.pokemonapplication.core.di.modules.view

import com.veronica.idn.pokemonapplication.presentation.detail.DetailFragment
import com.veronica.idn.pokemonapplication.presentation.detail.DetailInterface
import com.veronica.idn.pokemonapplication.presentation.detail.DetailPresenter
import com.veronica.idn.pokemonapplication.presentation.evolution.EvolutionFragment
import com.veronica.idn.pokemonapplication.presentation.evolution.EvolutionsInterface
import com.veronica.idn.pokemonapplication.presentation.evolution.EvolutionsPresenter
import com.veronica.idn.pokemonapplication.presentation.home.HomeFragment
import com.veronica.idn.pokemonapplication.presentation.home.HomeInterface
import com.veronica.idn.pokemonapplication.presentation.home.HomePresenter
import com.veronica.idn.pokemonapplication.presentation.stats.StatsFragment
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

    @Binds
    abstract fun detailPresenter(pokemonDetailPresenter: DetailPresenter<DetailInterface.View>): DetailInterface.Presenter<DetailInterface.View>

    @ContributesAndroidInjector
    abstract fun statsFragment(): StatsFragment

    @ContributesAndroidInjector
    abstract fun evolutionsFragment(): EvolutionFragment

    @Binds
    abstract fun evolutionPresenter(pokemonEvolutionPresenter: EvolutionsPresenter<EvolutionsInterface.View>): EvolutionsInterface.Presenter<EvolutionsInterface.View>

}
