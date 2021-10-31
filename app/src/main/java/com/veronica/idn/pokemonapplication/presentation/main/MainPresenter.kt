package com.veronica.idn.pokemonapplication.presentation.main


import com.veronica.idn.pokemonapplication.core.utils.RxScheduler
import com.veronica.idn.pokemonapplication.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainPresenter<V : MainInterface.View>
@Inject internal constructor(
    compositeDisposable: CompositeDisposable,
    scheduler: RxScheduler
) : BasePresenter<V>(compositeDisposable, scheduler),
    MainInterface.Presenter<V>