package io.github.bayu1993.movieapps.ui.detail

import android.view.View
import io.github.bayu1993.movieapps.data.PopularMovie
import io.github.bayu1993.movieapps.ui.base.BaseContract

/**
 * Created by Bayu teguh pamuji on 12/12/18.
 * email : bayuteguhpamuji@gmail.com.
 */
interface DetailContract {
    interface Presenter:BaseContract.Presenter<View>{
        fun getDetailMovie(id:Int)
    }

    interface View:BaseContract.View{
        fun showDetail(movie:PopularMovie)
    }
}