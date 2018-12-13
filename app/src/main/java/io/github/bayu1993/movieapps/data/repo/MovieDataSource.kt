package io.github.bayu1993.movieapps.data.repo

import io.github.bayu1993.movieapps.data.MoviesModel
import io.github.bayu1993.movieapps.data.PopularMovie
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Bayu teguh pamuji on 12/3/18.
 * email : bayuteguhpamuji@gmail.com.
 */

interface MovieDataSource{
    fun getPopularsMovies(): Single<List<PopularMovie>>
    fun getDetailMovie(id:Int):Single<PopularMovie>
}