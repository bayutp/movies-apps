package io.github.bayu1993.movieapps.data.repo

import io.github.bayu1993.movieapps.data.MoviesModel
import io.reactivex.Observable

/**
 * Created by Bayu teguh pamuji on 12/3/18.
 * email : bayuteguhpamuji@gmail.com.
 */
class MovieRepo(val remoteMovieDataSource: RemoteMovieDataSource) {
    fun getPopularMovies(): Observable<MoviesModel.ResponseModel> = remoteMovieDataSource.getPopularsMovies()

    companion object {
        var INSTANCE: MovieRepo? = null

        fun getInstance(remoteMovieDataSource: RemoteMovieDataSource): MovieRepo =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: MovieRepo(remoteMovieDataSource).also { INSTANCE = it }
            }
    }
}