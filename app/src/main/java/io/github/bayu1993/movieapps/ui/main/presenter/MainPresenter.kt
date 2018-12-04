package io.github.bayu1993.movieapps.ui.main.presenter

import com.google.gson.Gson
import io.github.bayu1993.movieapps.data.repo.MovieRepo
import io.github.bayu1993.movieapps.ui.main.view.MovieContract
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber

/**
 * Created by Bayu teguh pamuji on 12/3/18.
 * email : bayuteguhpamuji@gmail.com.
 */

class MainPresenter(val movieRepo: MovieRepo, val compositeDisposable: CompositeDisposable) : MovieContract.Presenter {
    private var mView: MovieContract.View? = null

    override fun getPopularMovies() {
        mView?.showView()
        movieRepo.getPopularMovies().subscribeBy(
            onNext = {
                mView?.hideView()
                mView?.showPopularMovies(it.results)
                Timber.d("result : ${Gson().toJsonTree(it.results)}")
            },
            onError = {
                mView?.hideView()
                Timber.e(it.localizedMessage)
            }
        ).addTo(compositeDisposable)
    }

    override fun onAttach(view: MovieContract.View) {
        mView = view
    }

    override fun onDetach() {
        mView = null
        compositeDisposable.clear()
    }

}