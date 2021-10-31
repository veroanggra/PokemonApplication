package com.veronica.idn.pokemonapplication

import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.LifecycleObserver
import com.veronica.idn.pokemonapplication.BuildConfig.*
import com.veronica.idn.pokemonapplication.core.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber


open class PokemonApplication : DaggerApplication(), LifecycleObserver {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        if (DEBUG) Timber.plant(Timber.DebugTree())
    }
    override fun applicationInjector(): AndroidInjector<out DaggerApplication?>? {
        return DaggerAppComponent.builder().application(this).build()
    }
}
