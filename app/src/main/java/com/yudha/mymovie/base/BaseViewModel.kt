package com.yudha.mymovie.base

import android.arch.lifecycle.ViewModel
import com.yudha.mymovie.di.AppComponent
import com.yudha.mymovie.di.DaggerAppComponent
import com.yudha.mymovie.di.NetworkModule
import com.yudha.mymovie.view.genre.GenreViewModel
import com.yudha.mymovie.view.review.ReviewViewModel
import com.yudha.mymovie.view.details.MovieDetailsViewModel
import com.yudha.mymovie.view.movie.MovieViewModel
import com.yudha.mymovie.view.video.VideoViewModel

/**
 * Created by yudha on 16,July,2019
 */
abstract class BaseViewModel: ViewModel() {
    private val injector: AppComponent = DaggerAppComponent
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when(this){
            is GenreViewModel -> injector.inject(this)
            is MovieViewModel -> injector.inject(this)
            is MovieDetailsViewModel -> injector.inject(this)
            is ReviewViewModel -> injector.inject(this)
            is VideoViewModel -> injector.inject(this)
        }
    }


}