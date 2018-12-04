package io.github.bayu1993.movieapps.ui.base

/**
 * Created by Bayu teguh pamuji on 12/3/18.
 * email : bayuteguhpamuji@gmail.com.
 */
interface BaseContract {
    interface Presenter<in V : View> {
        fun onAttach(view: V)
        fun onDetach()
    }

    interface View {
        fun onAttachView()
        fun onDetachView()
    }
}