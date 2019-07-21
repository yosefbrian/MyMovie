package com.yudha.mymovie.di

import com.yudha.mymovie.view.details.MovieDetailsViewModel
import com.yudha.mymovie.view.genre.GenreViewModel
import com.yudha.mymovie.view.movie.MovieViewModel
import com.yudha.mymovie.view.review.ReviewViewModel
import com.yudha.mymovie.view.video.VideoViewModel
import dagger.Component

/**
 * Created by yudha on 16,July,2019
 */
@Component(modules = [(NetworkModule::class)])
interface AppComponent {
    fun inject(GenreViewModel: GenreViewModel)
    fun inject(movieViewModel: MovieViewModel)
    fun inject(movieDetailsViewModel: MovieDetailsViewModel)
    fun inject(reviewViewModel: ReviewViewModel)
    fun inject(videoViewModel: VideoViewModel)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun networkModule(networkModule: NetworkModule): Builder
    }
}