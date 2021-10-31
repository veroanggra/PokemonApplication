package com.veronica.idn.pokemonapplication.presentation.evolution


import com.veronica.idn.pokemonapplication.core.utils.RxScheduler
import com.veronica.idn.pokemonapplication.domain.usecase.GetVarietySumList
import com.veronica.idn.pokemonapplication.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class EvolutionsPresenter<V : EvolutionsInterface.View>
@Inject internal constructor(
    compositeDisposable: CompositeDisposable,
    scheduler: RxScheduler,
    private val getVarietySumList: GetVarietySumList,
) : BasePresenter<V>(compositeDisposable, scheduler),
    EvolutionsInterface.Presenter<V> {

    override fun getVarietySums(names: List<String>) {
        enqueue(
            getVarietySumList.execute(names)
                .compose(scheduler.singleIoUi())
                .doOnSubscribe { view.showMainProgressBar(true) }
                .doAfterTerminate { view.showMainProgressBar(false) }
                .subscribe({
                    view.showVarietySums(it)
                }, {
                    view.showError(it.toString())
                })
        )
    }
}