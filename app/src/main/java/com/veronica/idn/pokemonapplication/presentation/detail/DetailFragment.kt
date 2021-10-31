package com.veronica.idn.pokemonapplication.presentation.detail


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.veronica.idn.pokemonapplication.R
import com.veronica.idn.pokemonapplication.core.utils.DataConverter
import com.veronica.idn.pokemonapplication.databinding.FragmentDetailBinding
import com.veronica.idn.pokemonapplication.domain.entity.PokemonDetail
import com.veronica.idn.pokemonapplication.presentation.base.BaseFragment
import com.veronica.idn.pokemonapplication.presentation.evolution.EvolutionFragment
import com.veronica.idn.pokemonapplication.presentation.stats.StatsFragment
import com.veronica.idn.pokemonapplication.presentation.util.AppBarScrollWatcher
import timber.log.Timber
import javax.inject.Inject


class DetailFragment : BaseFragment<FragmentDetailBinding>(), DetailInterface.View {
    @Inject
    lateinit var presenter: DetailInterface.Presenter<DetailInterface.View>
    private lateinit var appBarWatcher: AppBarScrollWatcher
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailBinding
        get() = FragmentDetailBinding::inflate

    @Inject
    lateinit var converter: DataConverter

    override fun setupPresenter() {
        presenter.attachView(this, this.lifecycle)
    }

    override fun showDetail(detail: PokemonDetail) {
        val fragStats = StatsFragment.newInstance(detail)
        val fragEvolutions = EvolutionFragment.newInstance(detail)
        binding.tabsMenu.setOnCheckedChangeListener { _, i ->
            val transaction = childFragmentManager.beginTransaction()
            when (i) {
                R.id.rbStats -> transaction.replace(R.id.fragmentDetail, fragStats)
                R.id.rbEvolution -> transaction.replace(R.id.fragmentDetail, fragEvolutions)
            }
            transaction.commit()
        }
        binding.tabsMenu.check(R.id.rbStats)

        binding.tlDetail.setBackgroundResource(getBackground(detail.color))

        Glide.with(this)
            .load(detail.sprite)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.ivTopDetail)

        Glide.with(this)
            .load(detail.types[0].tagRes)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.ivFirstTypeDetail)

        if (detail.types.size > 1) {
            Glide.with(this)
                .load(detail.types[1].tagRes)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.ivSecondTypeDetail)
            binding.ivSecondTypeDetail.visibility = View.VISIBLE
        }

        val name = detail.name.replaceFirstChar { it.uppercaseChar() }
        binding.tvTitleDetail.text = name
        binding.tvNameDetail.text = name
        binding.tvFlavorDetail.text = detail.flavor.text    }

    private fun getBackground(color: String): Int {
        var bg = converter.getResourceId("background_activity_default", R.drawable::class.java)
        try {
            bg = converter.getResourceId("bg_activity_$color", R.drawable::class.java)
        } catch (e: Exception) {
            Timber.e(e.stackTraceToString())
        }
        return bg
    }
    override fun onPresenterAttached() {
        binding.ivArrowDown.setOnClickListener { binding.appBarDetail.setExpanded(true, true) }
        appBarWatcher =
            AppBarScrollWatcher { _, _, argbZeroOnExpanded, _, alphaZeroOnCollapsed, alphaZeroOnExpanded ->
                binding.tabsMenu.background.alpha = argbZeroOnExpanded
                binding.tvTitleDetail.alpha = alphaZeroOnExpanded
                binding.ivArrowDown.alpha = alphaZeroOnExpanded
                binding.ivTopDetail.alpha = alphaZeroOnCollapsed
                binding.tvTypeDetail.alpha = alphaZeroOnCollapsed
                binding.tvNameDetail.alpha = alphaZeroOnCollapsed
                binding.tvFlavorDetail.alpha = alphaZeroOnCollapsed
                binding.backgroundStickyDetail.alpha = alphaZeroOnCollapsed
            }
        binding.appBarDetail.addOnOffsetChangedListener(appBarWatcher)

        val args: DetailFragmentArgs by navArgs()
        val name = args.pokemonSum.name
        val spName = args.pokemonSum.speciesName
        presenter.getPokemonDetail(name, spName)    }

    override fun showMainProgressBar(show: Boolean) {
        binding.shimmerDetail.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showError(message: String?) {
        Timber.e(message)
        binding.llDetailError.visibility = if (message=="Failed") View.VISIBLE else View.GONE
    }

}