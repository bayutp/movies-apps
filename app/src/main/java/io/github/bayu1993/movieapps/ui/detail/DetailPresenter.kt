package io.github.bayu1993.movieapps.ui.detail

import android.app.Application
import android.widget.Toast
import io.github.bayu1993.movieapps.data.repo.MovieRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by Bayu teguh pamuji on 12/12/18.
 * email : bayuteguhpamuji@gmail.com.
 */
class DetailPresenter(val movieRepo: MovieRepo, val compositeDisposable: CompositeDisposable): DetailContract.Presenter {
    private var mView:DetailContract.View? = null
    override fun getDetailMovie(id:Int) {
        movieRepo.getDetailMovie(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeBy(onSuccess = {
                mView?.showDetail(it)
                Timber.d("result : $it")
            }, onError = {
                Timber.e(it.localizedMessage)
            }).addTo(compositeDisposable)
    }

    override fun onAttach(view: DetailContract.View) {
        mView = view
    }

    override fun onDetach() {
        mView = null
        compositeDisposable.clear()
    }


}