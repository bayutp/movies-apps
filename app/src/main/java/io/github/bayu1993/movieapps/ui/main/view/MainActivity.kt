package io.github.bayu1993.movieapps.ui.main.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import io.github.bayu1993.movieapps.R
import io.github.bayu1993.movieapps.data.PopularMovie
import io.github.bayu1993.movieapps.ui.detail.DetailActivity
import io.github.bayu1993.movieapps.ui.main.adapter.MoviesAdapter
import io.github.bayu1993.movieapps.ui.main.presenter.MainPresenter
import io.github.bayu1993.movieapps.utils.ID_MOVIE
import io.github.bayu1993.movieapps.utils.gone
import io.github.bayu1993.movieapps.utils.visible
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), MovieContract.View {
    private val movieList: MutableList<PopularMovie> = mutableListOf()
    private lateinit var adapterMovies: MoviesAdapter
    private val mainPresenter: MainPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    override fun showPopularMovies(movies: List<PopularMovie>) {
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
        onAttachView()
        mainPresenter.getPopularMovies()

        adapterMovies = MoviesAdapter(movieList) {
            startActivity<DetailActivity>(ID_MOVIE to it.id)
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
