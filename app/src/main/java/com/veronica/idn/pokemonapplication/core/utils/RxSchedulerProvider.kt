package com.veronica.idn.pokemonapplication.core.utils

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RxSchedulerProvider @Inject constructor() :
    RxScheduler {
    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    override fun ui(): Scheduler? {
        return AndroidSchedulers.mainThread()
    }

    override fun <T> observableIo(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream: Observable<T> ->
            upstream.subscribeOn(io())
        }
    }

    override fun <T> observableIoUi(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream: Observable<T> ->
            upstream.subscribeOn(io()).observeOn(ui())
        }
    }

    override fun <T> observableComputationUi(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream: Observable<T> ->
            upstream.subscribeOn(computation()).observeOn(ui())
        }
    }

    override fun <T> singleIo(): SingleTransformer<T, T> {
        return SingleTransformer { upstream: Single<T> -> upstream.subscribeOn(io()) }
    }

    override fun <T> singleIoUi(): SingleTransformer<T, T> {
        return SingleTransformer { upstream: Single<T> ->
            upstream.subscribeOn(io()).observeOn(ui())
        }
    }

    override fun <T> singleComputationUi(): SingleTransformer<T, T> {
        return SingleTransformer { upstream: Single<T> ->
            upstream.subscribeOn(computation()).observeOn(ui())
        }
    }

    override fun <T> flowableIo(): FlowableTransformer<T, T> {
        return FlowableTransformer { upstream: Flowable<T> -> upstream.subscribeOn(io()) }
    }

    override fun <T> flowableIoUi(): FlowableTransformer<T, T> {
        return FlowableTransformer { upstream: Flowable<T> ->
            upstream.subscribeOn(io()).observeOn(ui())
        }
    }

    override fun <T> flowableComputationUi(): FlowableTransformer<T, T> {
        return FlowableTransformer { upstream: Flowable<T> ->
            upstream.subscribeOn(computation()).observeOn(ui())
        }
    }

    override fun <T> maybeIo(): MaybeTransformer<T, T> {
        return MaybeTransformer { upstream: Maybe<T> -> upstream.subscribeOn(io()) }
    }

    override fun <T> maybeIoUi(): MaybeTransformer<T, T> {
        return MaybeTransformer { upstream: Maybe<T> ->
            upstream.subscribeOn(io()).observeOn(ui())
        }
    }

    override fun <T> maybeComputationUi(): MaybeTransformer<T, T> {
        return MaybeTransformer { upstream: Maybe<T> ->
            upstream.subscribeOn(computation()).observeOn(ui())
        }
    }

    override fun completableIo(): CompletableTransformer {
        return CompletableTransformer { upstream: Completable -> upstream.subscribeOn(io()) }
    }

    override fun completableIoUi(): CompletableTransformer {
        return CompletableTransformer { upstream: Completable ->
            upstream.subscribeOn(io()).observeOn(ui())
        }
    }

    override fun completableComputationUi(): CompletableTransformer {
        return CompletableTransformer { upstream: Completable ->
            upstream.subscribeOn(computation()).observeOn(ui())
        }
    }
}