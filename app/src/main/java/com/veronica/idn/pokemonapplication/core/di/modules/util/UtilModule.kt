package com.veronica.idn.pokemonapplication.core.di.modules.util

import com.veronica.idn.pokemonapplication.core.di.components.ApplicationScope
import com.veronica.idn.pokemonapplication.core.utils.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
internal abstract class UtilModule {
    @ApplicationScope
    @Binds
    abstract fun dataConverter(dataConverterFactory: DataConverterFactory): DataConverter

    @ApplicationScope
    @Binds
    abstract fun rxScheduler(rxSchedulerProvider: RxSchedulerProvider): RxScheduler

    @ApplicationScope
    @Binds
    abstract fun deviceUtil(deviceUtilFactory: DeviceUtilFactory): DeviceUtil

    companion object {
        @Provides
        fun compositeDisposable(): CompositeDisposable = CompositeDisposable()

    }
}