package io.github.bayu1993.movieapps.main.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import io.github.bayu1993.movieapps.R
import io.github.bayu1993.movieapps.adapter.MoviesAdapter
import io.github.bayu1993.movieapps.data.MoviesModel
import io.github.bayu1993.movieapps.main.presenter.MainPresenter
import io.github.bayu1993.movieapps.utils.Injector
import io.github.bayu1993.movieapps.utils.gone
import io.github.bayu1993.movieapps.utils.visible
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), MovieContract.View {
    private val movieList: MutableList<MoviesModel.Result> = mutableListOf()
    private lateinit var adapterMovies: MoviesAdapter
    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    override fun showPopularMovies(movies: List<MoviesModel.Result>) {
        movieList.addAll(movies)
        adapterMovies.notifyDataSetChanged()
    }

    override fun onAttachView() {
        mainPresenter.onAttach(this)
    }

    override fun onDetachView() {
        mainPresenter.onDetach()
    }

    override fun showView() {
        progressbar.visible()
        rv_movie.gone()
    }

    override fun hideView() {
        progressbar.gone()
        rv_movie.visible()
    }

    private fun initView() {
        mainPresenter = Injector.provideMainPresenter()
        onAttachView()
        mainPresenter.getPopularMovies()

        adapterMovies = MoviesAdapter(movieList) {
            toast(it.original_title).show()
        }
        rv_movie.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            adapter = adapterMovies
        }
    }


    override fun onDestroy() {
        mainPresenter.onDetach()
        super.onDestroy()
    }
}
