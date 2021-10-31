package com.veronica.idn.pokemonapplication.core.utils

import io.reactivex.*

interface RxScheduler {
    fun io(): Scheduler
    fun computation(): Scheduler
    fun ui(): Scheduler?
    fun <T> observableIo(): ObservableTransformer<T, T>
    fun <T> observableIoUi(): ObservableTransformer<T, T>
    fun <T> observableComputationUi(): ObservableTransformer<T, T>
    fun <T> singleIo(): SingleTransformer<T, T>
    fun <T> singleIoUi(): SingleTransformer<T, T>
    fun <T> singleComputationUi(): SingleTransformer<T, T>
    fun <T> flowableIo(): FlowableTransformer<T, T>
    fun <T> flowableIoUi(): FlowableTransformer<T, T>
    fun <T> flowableComputationUi(): FlowableTransformer<T, T>
    fun <T> maybeIo(): MaybeTransformer<T, T>
    fun <T> maybeIoUi(): MaybeTransformer<T, T>
    fun <T> maybeComputationUi(): MaybeTransformer<T, T>
    fun completableIo(): CompletableTransformer
    fun completableIoUi(): CompletableTransformer
    fun completableComputationUi(): CompletableTransformer
}