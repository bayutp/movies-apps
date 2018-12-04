package io.github.bayu1993.movieapps.main.presenter

import com.google.gson.Gson
import io.github.bayu1993.movieapps.data.repo.MovieRepo
import io.github.bayu1993.movieapps.main.view.MovieContract
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
        movieRepo.getPopularMovies().subscribeBy(
            onNext = {
                mView?.showView()
                mView?.showPopularMovies(it.results)
                mView?.hideView()
                Timber.d("result : ${Gson().toJsonTree(it.results)}")
            },
            onError = {
                mView?.showView()
                Timber.e(it.localizedMessage)
                mView?.hideView()
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