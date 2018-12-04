package io.github.bayu1993.movieapps.utils

import io.github.bayu1993.movieapps.data.repo.MovieRepo
import io.github.bayu1993.movieapps.data.repo.RemoteMovieDataSource
import io.github.bayu1993.movieapps.main.presenter.MainPresenter
import io.github.bayu1993.movieapps.network.MovieClient
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Bayu teguh pamuji on 12/4/18.
 * email : bayuteguhpamuji@gmail.com.
 */
object Injector {
    fun provideMainPresenter() = MainPresenter(getMovieRepo(), getCompositeDisposable())

    fun getCompositeDisposable() = CompositeDisposable()

    fun getMovieRepo() = MovieRepo.getInstance(provideRemoteMovieDataSource())

    fun provideRemoteMovieDataSource() = RemoteMovieDataSource(provideMovieService())

    fun provideMovieService() = MovieClient.create()
}
