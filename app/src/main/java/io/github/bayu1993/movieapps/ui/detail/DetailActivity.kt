package io.github.bayu1993.movieapps.ui.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.github.bayu1993.movieapps.R
import io.github.bayu1993.movieapps.data.PopularMovie
import io.github.bayu1993.movieapps.utils.BASE_IMAGE_URL
import io.github.bayu1993.movieapps.utils.ID_MOVIE
import io.github.bayu1993.movieapps.utils.loadImage
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.ext.android.inject

class DetailActivity : AppCompatActivity(), DetailContract.View {

    private val detailPresenter: DetailPresenter by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        getMovieDetail()
    }

    private fun getMovieDetail() {
        onAttachView()
        val id = intent.getIntExtra(ID_MOVIE, 0)
        detailPresenter.getDetailMovie(id)
    }

    override fun showDetail(movie: PopularMovie) {
        img_cover.loadImage("$BASE_IMAGE_URL${movie.image}")
        tv_title.text = movie.title
        tv_desc.text = movie.desc
    }

    override fun onAttachView() {
        detailPresenter.onAttach(this)
    }

    override fun onDetachView() {
        detailPresenter.onDetach()
    }

    override fun onDestroy() {
        super.onDestroy()
        detailPresenter.onDetach()
    }
}
