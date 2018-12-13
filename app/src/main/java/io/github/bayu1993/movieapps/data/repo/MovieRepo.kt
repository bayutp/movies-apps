package io.github.bayu1993.movieapps.data.repo

import io.github.bayu1993.movieapps.data.PopularMovie
import io.github.bayu1993.movieapps.data.local.PopularMovieEntity
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by Bayu teguh pamuji on 12/3/18.
 * email : bayuteguhpamuji@gmail.com.
 */
class MovieRepo(val remoteMovieDataSource: RemoteMovieDataSource, val localDataSources: LocalDataSources) :
    MovieDataSource {
    override fun getDetailMovie(id: Int): Single<PopularMovie> {
        return localDataSources.getDetailMovie(id)
            .map { PopularMovie.from(it) }
            .flatMap { Single.just(it) }
    }

    override fun getPopularsMovies(): Single<List<PopularMovie>> {
        return localDataSources.getPopularsMovies()
            .map { list ->
                list.map { PopularMovie.from(it) }
            }
            .flatMap {
                if (it.isEmpty()) getPopularMoviesFromRemote() else
                    Single.just(it)
            }
            .doAfterSuccess {
                getPopularMoviesFromRemote()
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        Timber.d("refresh data")
                    }, {
                        Timber.e(it.localizedMessage)
                    })
            }

    }

    private fun getPopularMoviesFromRemote(): Single<List<PopularMovie>> {
        return remoteMovieDataSource.getPopularsMovies()
            .doOnSuccess {
                localDataSources.savePopularMovies(it.results.map {
                    PopularMovieEntity.from(it)
                })
            }
            .map { list -> list.results.map { PopularMovie.from(it) } }
    }
}