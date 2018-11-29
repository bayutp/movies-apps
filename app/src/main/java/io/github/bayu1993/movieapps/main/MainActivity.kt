package io.github.bayu1993.movieapps.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.google.gson.Gson
import io.github.bayu1993.movieapps.R
import io.github.bayu1993.movieapps.utils.gone
import io.github.bayu1993.movieapps.adapter.MoviesAdapter
import io.github.bayu1993.movieapps.data.MoviesModel
import io.github.bayu1993.movieapps.network.MovieClient
import io.github.bayu1993.movieapps.network.MovieService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()
    private val movieList: MutableList<MoviesModel.Result> = mutableListOf()
    private lateinit var movieService: MovieService
    private lateinit var adapterMovies: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        getPopularMovies()
    }

    private fun initView() {
        adapterMovies = MoviesAdapter(movieList)
        movieService = MovieClient.create()
        rv_movie.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            adapter = adapterMovies
        }
    }

    private fun getPopularMovies() {
        compositeDisposable.add(
                movieService.getPopilarMovies()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({
                            progressbar.gone()
                            movieList.addAll(it.results)
                            adapterMovies.notifyDataSetChanged()
                            Log.d(MainActivity::class.java.simpleName, "${Gson().toJsonTree(movieList)}")

                        }, {
                            toast(it.localizedMessage)
                        })
        )
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}
