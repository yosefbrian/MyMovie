package com.yudha.mymovie.view

import android.util.Log
import com.yudha.mymovie.base.BaseViewModel
import com.yudha.mymovie.network.MovieDbServices
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by yudha on 16,July,2019
 */
class MainActivityViewModel: BaseViewModel() {
    @Inject lateinit var movieDbServices: MovieDbServices

    init {
        loadPosts()
    }

    private fun loadPosts(){
        val genre = movieDbServices.getGenres().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( { result -> Log.d("testresponse", result.genres.first().name) },
                {
                    Log.d("testresponse", it.toString())
                }
            )
    }
}