package io.github.bayu1993.movieapps.ui.main.view

import io.github.bayu1993.movieapps.ui.base.BaseContract
import io.github.bayu1993.movieapps.data.MoviesModel
import io.github.bayu1993.movieapps.data.PopularMovie

/**
 * Created by Bayu teguh pamuji on 12/4/18.
 * email : bayuteguhpamuji@gmail.com.
 */
interface MovieContract {
    interface Presenter : BaseContract.Presenter<View>{
        fun getPopularMovies()
    }
    interface View: BaseContract.View{
        fun showPopularMovies(movies:List<PopularMovie>)
        fun showView()
        fun hideView()
    }
}