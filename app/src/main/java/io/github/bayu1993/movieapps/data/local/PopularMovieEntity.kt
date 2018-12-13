package io.github.bayu1993.movieapps.data.local

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import io.github.bayu1993.movieapps.data.MoviesModel
import io.github.bayu1993.movieapps.data.PopularMovie

/**
 * Created by Bayu teguh pamuji on 12/10/18.
 * email : bayuteguhpamuji@gmail.com.
 */
@Entity(tableName = "movies")
class PopularMovieEntity(
    @PrimaryKey(autoGenerate = false)
    val id:Int,
    val title:String,
    @ColumnInfo(name = "poster_path")
    val image: String,
    @ColumnInfo(name = "vote_average")
    val vote_average: Double,
    @ColumnInfo(name = "overview")
    val overview: String,
    val release_date: String
    ){
    companion object {
        fun from(data:MoviesModel.Result) = PopularMovieEntity(
            data.id,
            data.title,
            data.poster_path,
            data.vote_average,
            data.overview,
            data.release_date
        )
    }
}