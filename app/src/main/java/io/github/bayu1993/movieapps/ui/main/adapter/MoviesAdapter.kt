package io.github.bayu1993.movieapps.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.bayu1993.movieapps.R
import io.github.bayu1993.movieapps.ui.main.adapter.MoviesAdapter.ViewHolder
import io.github.bayu1993.movieapps.data.MoviesModel
import io.github.bayu1993.movieapps.data.PopularMovie
import io.github.bayu1993.movieapps.utils.BASE_IMAGE_URL
import io.github.bayu1993.movieapps.utils.loadImage
import kotlinx.android.synthetic.main.item_movies.view.*

/**
 * Created by Bayu teguh pamuji on 11/28/18.
 * email : bayuteguhpamuji@gmail.com.
 */

class MoviesAdapter(private val movies: List<PopularMovie>,private val listener: (movie: PopularMovie) -> Unit)
    : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false))
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movie: PopularMovie, listener: (movie: PopularMovie) -> Unit) {
            itemView.img_movies.loadImage("$BASE_IMAGE_URL${movie.image}")
            itemView.setOnClickListener { listener(movie) }
        }
    }

}