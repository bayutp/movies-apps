package io.github.bayu1993.movieapps.data.repo

import io.github.bayu1993.movieapps.data.MoviesModel
import io.github.bayu1993.movieapps.network.MovieService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Bayu teguh pamuji on 12/3/18.
 * email : bayuteguhpamuji@gmail.com.
 */
class RemoteMovieDataSource(val movieService: MovieService) : MovieDataSource {
    override fun getPopularsMovies(): Observable<MoviesModel.ResponseModel> {
        return movieService.getPopilarMovies()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }


}