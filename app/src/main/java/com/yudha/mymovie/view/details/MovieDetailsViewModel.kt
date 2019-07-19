package com.yudha.mymovie.view.details

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.yudha.mymovie.base.BaseViewModel
import com.yudha.mymovie.model.MovieResult
import com.yudha.mymovie.network.MovieDbServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieDetailsViewModel : BaseViewModel() {
    @Inject
    lateinit var movieDbServices: MovieDbServices
    val loadingVisibility = MutableLiveData<Int>()
    val movieLiveData = MutableLiveData<MovieResult>()
    val movieIdLiveData = MutableLiveData<Int>()


    @SuppressLint("CheckResult")
    fun loadMovie(movieId: Int){
        movieDbServices.getMovie(movieId).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { loadingVisibility.value = View.VISIBLE }
            .doOnTerminate{ loadingVisibility.value = View.GONE }
            .subscribe( { result ->
                showItem(result)
            },
                {}
            )
    }

    private fun showItem(result: MovieResult){
        movieLiveData.value = result
    }
}
