package io.github.bayu1993.movieapps

import android.app.Application
import io.github.bayu1993.movieapps.di.dataModule
import io.github.bayu1993.movieapps.di.networkModule
import io.github.bayu1993.movieapps.di.presenterModule
import io.github.bayu1993.movieapps.di.schedullerModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber

/**
 * Created by Bayu teguh pamuji on 12/4/18.
 * email : bayuteguhpamuji@gmail.com.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        startKoin(this, listOf(networkModule, dataModule, presenterModule, schedullerModule))
    }
}