package com.veronica.idn.pokemonapplication.presentation.detail


import com.veronica.idn.pokemonapplication.core.utils.RxScheduler
import com.veronica.idn.pokemonapplication.domain.params.PokemonDetailParam
import com.veronica.idn.pokemonapplication.domain.usecase.GetPokemonDetail
import com.veronica.idn.pokemonapplication.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class DetailPresenter<V : DetailInterface.View>
@Inject internal constructor(
    compositeDisposable: CompositeDisposable,
    scheduler: RxScheduler,
    private val getPokemonDetail: GetPokemonDetail,
) : BasePresenter<V>(compositeDisposable, scheduler),
    DetailInterface.Presenter<V> {

    override fun getPokemonDetail(pokemonName: String, speciesName: String) {
        enqueue(getPokemonDetail.execute(PokemonDetailParam(pokemonName, speciesName))
            .compose(scheduler.observableIoUi())
            .doOnSubscribe { view.showMainProgressBar(true) }
            .doAfterTerminate { view.showMainProgressBar(false) }
            .subscribe({
                view.showDetail(it)
            }, {
                view.showError("Failed")
            })
        )
    }
}