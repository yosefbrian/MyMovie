package com.yudha.mymovie.view

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.yudha.mymovie.R
import com.yudha.mymovie.base.BaseViewModel
import com.yudha.mymovie.network.MovieDbServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by yudha on 16,July,2019
 */
class MainActivityViewModel: BaseViewModel() {

    @Inject
    lateinit var movieDbServices: MovieDbServices
    val adapter: GenreAdapter = GenreAdapter()
    val loadingVisibility = MutableLiveData<Int>()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()

    init { loadGenres() }

    @SuppressLint("CheckResult")
    private fun loadGenres(){
        movieDbServices.getGenres().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { loadingVisibility.value = View.VISIBLE }
            .doOnTerminate{ loadingVisibility.value = View.GONE }
            .subscribe( { result ->
                adapter.updateData(result)
            },
                {
                    errorMessage.value = R.string.error
                }
            )
    }



}