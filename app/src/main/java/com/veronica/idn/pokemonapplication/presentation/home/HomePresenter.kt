package com.veronica.idn.pokemonapplication.presentation.home

import com.veronica.idn.pokemonapplication.core.utils.RxScheduler
import com.veronica.idn.pokemonapplication.domain.usecase.GetPokemonList
import com.veronica.idn.pokemonapplication.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomePresenter<V : HomeInterface.View>
@Inject internal constructor(
    compositeDisposable: CompositeDisposable,
    scheduler: RxScheduler,
    private val getPokemonList: GetPokemonList
) : BasePresenter<V>(compositeDisposable, scheduler),
    HomeInterface.Presenter<V> {
    override fun getPokemonList() {
        enqueue(getPokemonList.execute(null)
            .compose(scheduler.singleIoUi())
            .doOnSubscribe { view.showMainProgressBar(true) }
            .doAfterTerminate { view.showMainProgressBar(false) }
            .subscribe({
                view.showPokemonList(it)
            }, {
                view.showError("Failed")
            })
        )
    }
}