package com.veronica.idn.pokemonapplication.core.di.modules.data

import android.content.Context
import androidx.room.Room
import com.veronica.idn.pokemonapplication.core.di.components.ApplicationScope
import com.veronica.idn.pokemonapplication.core.di.configuration.ApplicationContext
import com.veronica.idn.pokemonapplication.data.local.db.AppDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [LocalDataSourceModule::class])
internal abstract class LocalDataModule {

    companion object {
        @ApplicationScope
        @Provides
        fun appDatabase(@ApplicationContext context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
    }
}