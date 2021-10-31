package com.veronica.idn.pokemonapplication.core.di.modules

import android.app.Application
import android.content.Context
import com.veronica.idn.pokemonapplication.core.di.components.ApplicationScope
import com.veronica.idn.pokemonapplication.core.di.configuration.ApplicationContext
import com.veronica.idn.pokemonapplication.core.di.modules.data.DataModule
import com.veronica.idn.pokemonapplication.core.di.modules.receiver.BroadcastReceiverBuilder
import com.veronica.idn.pokemonapplication.core.di.modules.util.UtilModule
import com.veronica.idn.pokemonapplication.core.di.modules.view.ActivityBuilder
import com.veronica.idn.pokemonapplication.core.di.modules.view.FragmentBuilder
//import com.veronica.idn.pokemonapplication.core.di.modules.data.DataModule
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        DataModule::class,
        ActivityBuilder::class,
        FragmentBuilder::class,
        BroadcastReceiverBuilder::class,
        UtilModule::class
    ]
)
abstract class AppModule {
    @ApplicationScope
    @ApplicationContext
    @Binds
    abstract fun context(application: Application): Context
}