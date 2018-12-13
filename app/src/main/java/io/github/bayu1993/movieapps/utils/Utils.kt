package io.github.bayu1993.movieapps.utils

import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by Bayu teguh pamuji on 11/28/18.
 * email : bayuteguhpamuji@gmail.com.
 */

const val MOVIE_ENDPOINT = "movie/popular"
const val BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w185_and_h278_bestv2"
const val ID_MOVIE = "ID_MOVIE"

fun ImageView.loadImage(url: String) {
    Picasso.get()
        .load(url)
        .into(this)
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}