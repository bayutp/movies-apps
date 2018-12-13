package io.github.bayu1993.movieapps.network

import io.github.bayu1993.movieapps.BuildConfig
import io.github.bayu1993.movieapps.data.MoviesModel.ResponseModel
import io.github.bayu1993.movieapps.utils.MOVIE_ENDPOINT
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Bayu teguh pamuji on 11/28/18.
 * email : bayuteguhpamuji@gmail.com.
 */

interface MovieService {
    @GET(MOVIE_ENDPOINT)
    fun getPopilarMovies(@Query("api_key") apiKey: String = BuildConfig.API_KEY): Single<ResponseModel>
}