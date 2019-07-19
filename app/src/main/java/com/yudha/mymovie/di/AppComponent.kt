package com.yudha.mymovie.di

import com.yudha.mymovie.view.MainActivityViewModel
import com.yudha.mymovie.view.review.ReviewViewModel
import com.yudha.mymovie.view.details.MovieDetailsViewModel
import com.yudha.mymovie.view.movie.MovieActivityViewModel
import com.yudha.mymovie.view.video.VideoViewModel
import dagger.Component

/**
 * Created by yudha on 16,July,2019
 */
@Component(modules = [(NetworkModule::class)])
interface AppComponent {
    fun inject(mainActivityViewModel: MainActivityViewModel)
    fun inject(movieActivityViewModel: MovieActivityViewModel)
    fun inject(movieDetailsViewModel: MovieDetailsViewModel)
    fun inject(reviewViewModel: ReviewViewModel)
    fun inject(videoViewModel: VideoViewModel)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun networkModule(networkModule: NetworkModule): Builder
    }
}