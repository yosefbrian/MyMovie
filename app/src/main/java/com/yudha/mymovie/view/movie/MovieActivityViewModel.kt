package com.yudha.mymovie.view.movie

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import android.view.View
import android.widget.Toast
import com.yudha.mymovie.base.BaseViewModel
import com.yudha.mymovie.model.Movie
import com.yudha.mymovie.network.MovieDbServices
import com.yudha.mymovie.utils.ItemClickListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieActivityViewModel : BaseViewModel() {

    @Inject
    lateinit var movieDbServices: MovieDbServices
    val loadingVisibility = MutableLiveData<Int>()
    var data: Movie = Movie()
    private val clickListener = ObservableField<ItemClickListener>()
    val movieIdLiveData = MutableLiveData<Int>()
    val adapter: MovieAdapter = MovieAdapter()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()

    @SuppressLint("CheckResult")
    fun loadMovies(genreId: Int){
        movieDbServices.getMovies(genreId).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { loadingVisibility.value = View.VISIBLE }
            .doOnTerminate{ loadingVisibility.value = View.GONE }
            .subscribe( { result ->
                showItem(result)
            },
                {

                }
            )
    }

    private fun showItem(result: Movie){
        data = result
        clickListener.set(object : ItemClickListener {
            override fun onClick(id: Int) {
                movieIdLiveData.value = id
            }
        })
        adapter.updateData(data, clickListener.get()!!)
    }
}
