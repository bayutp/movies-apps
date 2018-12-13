package io.github.bayu1993.movieapps.data

import io.github.bayu1993.movieapps.data.local.PopularMovieEntity

/**
 * Created by Bayu teguh pamuji on 12/10/18.
 * email : bayuteguhpamuji@gmail.com.
 */
data class PopularMovie (
    val id: Int,
    val title:String,
    val image:String,
    val desc:String
){
    companion object {
        fun from(data:PopularMovieEntity) = PopularMovie(
            data.id,
            data.title,
            data.image,
            data.overview
        )

        fun from(data:MoviesModel.Result) = PopularMovie(
            data.id,
            data.title,
            data.poster_path,
            data.overview
        )
    }
}