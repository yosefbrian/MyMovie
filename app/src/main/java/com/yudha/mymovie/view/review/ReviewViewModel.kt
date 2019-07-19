package com.yudha.mymovie.view.review

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import android.view.View
import com.yudha.mymovie.base.BaseViewModel
import com.yudha.mymovie.model.Review
import com.yudha.mymovie.network.MovieDbServices
import com.yudha.mymovie.utils.ItemClickListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by yudha on 19,July,2019
 */
class ReviewViewModel: BaseViewModel() {
    @Inject
    lateinit var movieDbServices: MovieDbServices
    val loadingVisibility = MutableLiveData<Int>()
    var data: Review = Review()
    private val clickListener = ObservableField<ItemClickListener>()
    val movieIdLiveData = MutableLiveData<Int>()
    val adapter: ReviewAdapter = ReviewAdapter()


    @SuppressLint("CheckResult")
    fun loadReviews(movieId: Int){
        movieDbServices.getReviews(movieId).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { loadingVisibility.value = View.VISIBLE }
            .doOnTerminate{ loadingVisibility.value = View.GONE }
            .subscribe( { result ->
                showItem(result)
            },
                {}
            )
    }

    private fun showItem(result: Review){
        data = result
        clickListener.set(object : ItemClickListener {
            override fun onClick(id: Int) {
                movieIdLiveData.value = id
            }
        })
        adapter.updateData(data)
    }
}