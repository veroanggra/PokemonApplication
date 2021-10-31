package com.veronica.idn.pokemonapplication.core.di.modules.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.veronica.idn.pokemonapplication.BuildConfig
import com.veronica.idn.pokemonapplication.core.di.components.ApplicationScope
import com.veronica.idn.pokemonapplication.core.di.configuration.ApplicationContext
import com.veronica.idn.pokemonapplication.core.di.configuration.LoggingInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module(includes = [NetworkModule::class, RemoteDataSourceModule::class])
internal class RemoteDataModule {
    @ApplicationScope
    @Provides
    fun converter(): Gson {
        return GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create()
    }

    @Provides
    @LoggingInterceptor
    fun interceptor(): Interceptor {
        val logger = HttpLoggingInterceptor()
        logger.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return logger
    }


    @ApplicationScope
    @Provides
    fun cache(@ApplicationContext context: Context): Cache {
        return Cache(context.cacheDir, 10 * 1024 * 1024)
    }

    @ApplicationScope
    @Provides
    fun okHttpClient(@LoggingInterceptor loggingInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor) /* Debug logging */
            .connectTimeout(8, TimeUnit.SECONDS)
            .readTimeout(8, TimeUnit.SECONDS)
            .writeTimeout(8, TimeUnit.SECONDS)
            .build()
    }

    @ApplicationScope
    @Provides
    fun retrofit(client: OkHttpClient, converter: Gson): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(converter))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }
}