package com.yudha.mymovie.view

import android.annotation.SuppressLint
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.databinding.BindingAdapter
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
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val genreAdapter: GenreAdapter = GenreAdapter()
    var data: Genre = Genre()

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
                genreAdapter.updateGenre(result)
                data = result
            },
                {}
            )
    }

//    companion object {
//        @JvmStatic
//        @BindingAdapter("bind:response", "bind:clickListener")
//        fun bindListAdapter(reyclerView: RecyclerView, response: Genre?) {
//            if (response != null)
//                reyclerView.adapter = GenreAdapter(response)
//        }
//    }
}