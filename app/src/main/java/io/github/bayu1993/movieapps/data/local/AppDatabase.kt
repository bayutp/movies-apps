package io.github.bayu1993.movieapps.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by Bayu teguh pamuji on 12/10/18.
 * email : bayuteguhpamuji@gmail.com.
 */

@Database(entities = arrayOf(PopularMovieEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun popularMovieDao(): PopularMovieDao
}