package com.yudha.mymovie.view

import android.annotation.SuppressLint
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.databinding.BindingAdapter
import android.databinding.ObservableField
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.yudha.mymovie.base.BaseViewModel
import com.yudha.mymovie.model.Genre
import com.yudha.mymovie.network.MovieDbServices
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by yudha on 16,July,2019
 */
class MainActivityViewModel: BaseViewModel() {

    @Inject lateinit var movieDbServices: MovieDbServices
    val loadingVisibility = MutableLiveData<Int>()
    var data: Genre = Genre()
    val clickListener = ObservableField<ItemClickListener>()
    val genreIdLiveData = MutableLiveData<Int>()

    init {
        loadPosts()
    }

    @SuppressLint("CheckResult")
    private fun loadPosts(){
        movieDbServices.getGenres().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { loadingVisibility.value = View.VISIBLE }
            .doOnTerminate{ loadingVisibility.value = View.GONE }
            .subscribe( { result ->
                showItem(result)
            },
                {}
            )
    }

    private fun showItem(result: Genre){
        data = result
        clickListener.set(object : ItemClickListener {
            override fun onClick(id: Int) {
                genreIdLiveData.value = id
            }
        })

    }


}