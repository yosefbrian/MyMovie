package com.yudha.mymovie.view.movie

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.yudha.mymovie.base.BaseViewModel
import com.yudha.mymovie.network.MovieDbServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieActivityViewModel : BaseViewModel() {

    @Inject
    lateinit var movieDbServices: MovieDbServices
    val loadingVisibility = MutableLiveData<Int>()
    val adapter: MovieAdapter = MovieAdapter()

    init {
        loadingVisibility.value = View.VISIBLE
    }

    @SuppressLint("CheckResult")
    fun loadMovies(genreId: Int, page: Int){
        movieDbServices.getMovies(genreId, page).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate{ loadingVisibility.value = View.GONE }
            .subscribe( { result ->
                adapter.updateData(result)
            },
                {
                }
            )
    }
}
