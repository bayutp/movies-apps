package io.github.bayu1993.movieapps.data.repo

import io.github.bayu1993.movieapps.data.MoviesModel
import io.github.bayu1993.movieapps.data.local.PopularMovieDao
import io.github.bayu1993.movieapps.data.local.PopularMovieEntity
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Bayu teguh pamuji on 12/10/18.
 * email : bayuteguhpamuji@gmail.com.
 */
class LocalDataSources(val popularMovieDao: PopularMovieDao) {
    fun getPopularsMovies(): Single<List<PopularMovieEntity>> {
        return popularMovieDao.getPopularMovies()
    }
    fun savePopularMovies(movies:List<PopularMovieEntity>){
        popularMovieDao.inserts(movies)
    }
    fun getDetailMovie(id:Int):Single<PopularMovieEntity>{
        return popularMovieDao.getDetailMovie(id)
    }
}