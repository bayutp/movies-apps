package io.github.bayu1993.movieapps.data.repo

import io.github.bayu1993.movieapps.data.MoviesModel
import io.reactivex.Observable

/**
 * Created by Bayu teguh pamuji on 12/3/18.
 * email : bayuteguhpamuji@gmail.com.
 */

interface MovieDataSource{
    fun getPopularsMovies():Observable<MoviesModel.ResponseModel>
}