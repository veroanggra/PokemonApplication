package com.veronica.idn.pokemonapplication.core.di.modules.receiver

import com.veronica.idn.pokemonapplication.core.utils.ConnectivityReceiver
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BroadcastReceiverBuilder {
    @ContributesAndroidInjector
    abstract fun connectivityReceiver(): ConnectivityReceiver?
}