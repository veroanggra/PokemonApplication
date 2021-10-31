package com.veronica.idn.pokemonapplication.presentation.home

import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.veronica.idn.pokemonapplication.R
import com.veronica.idn.pokemonapplication.databinding.FragmentHomeBinding
import com.veronica.idn.pokemonapplication.domain.entity.PokemonSum
import com.veronica.idn.pokemonapplication.presentation.base.BaseFragment
import timber.log.Timber
import javax.inject.Inject


class HomeFragment : BaseFragment<FragmentHomeBinding>(), HomeInterface.View {

    @Inject
    lateinit var presenter: HomeInterface.Presenter<HomeInterface.View>


    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun setupPresenter() {
        presenter.attachView(this, this.lifecycle)
    }

    override fun showPokemonList(items: List<PokemonSum>) {
        val adapter = PokemonAdapter(items.toMutableList()){
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(it))
        }
        binding.rvHome.adapter = adapter
    }

    override fun onPresenterAttached() {
        val decoration = DividerItemDecoration(requireContext(), ClipDrawable.HORIZONTAL)
        binding.rvHome.addItemDecoration(decoration)
        presenter.getPokemonList()
    }

    override fun showMainProgressBar(show: Boolean) {
        binding.shimmerContainer.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showError(message: String?) {
        Timber.e(message)
        binding.llHomeError.visibility = if (message=="Failed") View.VISIBLE else View.GONE
    }


}