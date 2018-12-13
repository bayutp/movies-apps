package io.github.bayu1993.movieapps.di

import io.github.bayu1993.movieapps.ui.detail.DetailPresenter
import io.github.bayu1993.movieapps.ui.main.presenter.MainPresenter
import org.koin.dsl.module.module

/**
 * Created by Bayu teguh pamuji on 12/4/18.
 * email : bayuteguhpamuji@gmail.com.
 */

val presenterModule = module {
    factory { MainPresenter(get(),get()) }
    factory { DetailPresenter(get(),get()) }
}