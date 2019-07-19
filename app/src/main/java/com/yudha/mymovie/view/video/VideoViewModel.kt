package com.yudha.mymovie.view.video

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import android.view.View
import com.yudha.mymovie.base.BaseViewModel
import com.yudha.mymovie.model.Video
import com.yudha.mymovie.network.MovieDbServices
import com.yudha.mymovie.utils.VideoClickListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by yudha on 19,July,2019
 */
class VideoViewModel: BaseViewModel() {

    @Inject
    lateinit var movieDbServices: MovieDbServices
    val loadingVisibility = MutableLiveData<Int>()
    var data: Video = Video()
    private val clickListener = ObservableField<VideoClickListener>()
    val videoKeyLiveData = MutableLiveData<String>()
    val adapter: VideoAdapter = VideoAdapter()

    @SuppressLint("CheckResult")
    fun loadVideos(movieId: Int){
        movieDbServices.getVideos(movieId).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { loadingVisibility.value = View.VISIBLE }
            .doOnTerminate{ loadingVisibility.value = View.GONE }
            .subscribe( { result ->
                showItem(result)
            },
                {
                    it.printStackTrace()
                }
            )
    }

    private fun showItem(result: Video){
        data = result
        clickListener.set(object : VideoClickListener {
            override fun onClick(id: String) {
                videoKeyLiveData.value = id
            }
        })
        adapter.updateData(data, clickListener.get()!!)
    }

}