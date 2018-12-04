package io.github.bayu1993.movieapps.di

import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module.module

/**
 * Created by Bayu teguh pamuji on 12/4/18.
 * email : bayuteguhpamuji@gmail.com.
 */

val schedullerModule = module {
    factory { CompositeDisposable() }
}