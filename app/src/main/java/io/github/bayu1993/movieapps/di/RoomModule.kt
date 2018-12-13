package io.github.bayu1993.movieapps.di

import android.arch.persistence.room.Room
import io.github.bayu1993.movieapps.data.local.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

/**
 * Created by Bayu teguh pamuji on 12/10/18.
 * email : bayuteguhpamuji@gmail.com.
 */

val roomModule = module {
    single { Room.databaseBuilder(androidApplication(),AppDatabase::class.java,"movie_db").allowMainThreadQueries().build() }
    single { get<AppDatabase>().popularMovieDao() }
}