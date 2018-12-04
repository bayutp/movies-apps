package io.github.bayu1993.movieapps.di

import io.github.bayu1993.movieapps.data.repo.MovieRepo
import io.github.bayu1993.movieapps.data.repo.RemoteMovieDataSource
import org.koin.dsl.module.module

/**
 * Created by Bayu teguh pamuji on 12/4/18.
 * email : bayuteguhpamuji@gmail.com.
 */

val dataModule = module {
    single { RemoteMovieDataSource(get()) }
    single { MovieRepo(get()) }
}