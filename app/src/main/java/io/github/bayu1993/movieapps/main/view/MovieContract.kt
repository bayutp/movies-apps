package io.github.bayu1993.movieapps.main.view

import io.github.bayu1993.movieapps.base.BaseContract
import io.github.bayu1993.movieapps.data.MoviesModel

/**
 * Created by Bayu teguh pamuji on 12/4/18.
 * email : bayuteguhpamuji@gmail.com.
 */
interface MovieContract {
    interface Presenter : BaseContract.Presenter<View>{
        fun getPopularMovies()
    }
    interface View: BaseContract.View{
        fun showPopularMovies(movies:List<MoviesModel.Result>)
        fun showView()
        fun hideView()
    }
}