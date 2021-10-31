package com.veronica.idn.pokemonapplication.presentation.evolution

import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.veronica.idn.pokemonapplication.R
import com.veronica.idn.pokemonapplication.databinding.FragmentEvolutionBinding
import com.veronica.idn.pokemonapplication.domain.entity.PokemonDetail
import com.veronica.idn.pokemonapplication.domain.entity.Variety
import com.veronica.idn.pokemonapplication.presentation.base.BaseFragment
import timber.log.Timber
import javax.inject.Inject


class EvolutionFragment : BaseFragment<FragmentEvolutionBinding>(), EvolutionsInterface.View {
    @Inject
    lateinit var presenter: EvolutionsInterface.Presenter<EvolutionsInterface.View>
    private lateinit var detail: PokemonDetail

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentEvolutionBinding
        get() = FragmentEvolutionBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { detail = it.getParcelable(parcelPokemon)!! }
    }

    override fun setupPresenter() {
        presenter.attachView(this, this.lifecycle)
    }

    override fun showVarietySums(spSums: List<Variety>) {
        detail.evolutions.mapIndexed { i, evo ->
            Timber.e("Evo from ${evo.fromName}")
            val from = spSums.find { it.name == evo.fromName }
            if (from != null) {
                Timber.e("Found From ${from.name} -- ${from.sprite}")
                detail.evolutions[i].fromSprite = from.sprite
            }


            Timber.e("Evo to ${evo.toName}")
            val to = spSums.find { it.name == evo.toName }
            if (to != null) {
                Timber.e("Found To ${to.name} -- ${to.sprite}")
                detail.evolutions[i].toSprite = to.sprite
            }
        }

        val decor = DividerItemDecoration(requireContext(), ClipDrawable.HORIZONTAL)
        binding.rvEvolutions.addItemDecoration(decor)
        binding.rvEvolutions.adapter = EvolutionAdapter(detail.evolutions.toMutableList())    }

    override fun onPresenterAttached() {
        val names: ArrayList<String> = arrayListOf()
        detail.evolutions.map {
            names.add(it.fromName)
            names.add(it.toName)
        }
        presenter.getVarietySums(names.toSet().toList())    }

    override fun showMainProgressBar(show: Boolean) {
        binding.shimmerContainer.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showError(message: String?) {
    }

    companion object {
        const val parcelPokemon = "parcelPokemon"

        @JvmStatic
        fun newInstance(pokemonDetail: PokemonDetail) =
            EvolutionFragment().apply {
                arguments = Bundle().apply { putParcelable(parcelPokemon, pokemonDetail) }
            }
    }

}