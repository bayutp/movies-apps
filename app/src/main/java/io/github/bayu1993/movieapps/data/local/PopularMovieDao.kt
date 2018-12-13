package io.github.bayu1993.movieapps.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single

/**
 * Created by Bayu teguh pamuji on 12/10/18.
 * email : bayuteguhpamuji@gmail.com.
 */
@Dao
interface PopularMovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserts(movies: List<PopularMovieEntity>)

    @Query("SELECT * FROM movies")
    fun getPopularMovies(): Single<List<PopularMovieEntity>>

    @Query("SELECT * FROM movies WHERE id = :id")
    fun getDetailMovie(id: Int): Single<PopularMovieEntity>
}