package com.veronica.idn.pokemonapplication.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.veronica.idn.pokemonapplication.domain.entity.PokemonDetail
import com.veronica.idn.pokemonapplication.presentation.evolution.EvolutionFragment
import com.veronica.idn.pokemonapplication.presentation.stats.StatsFragment

class PokemonPagerAdapter(
    fragmentManager: FragmentManager, lifecycle: Lifecycle,
    private val count: Int,
    private val pokemonDetail: PokemonDetail
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = count

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> StatsFragment.newInstance(pokemonDetail)
            1 -> EvolutionFragment.newInstance(pokemonDetail)
            else -> StatsFragment()
        }
    }
}