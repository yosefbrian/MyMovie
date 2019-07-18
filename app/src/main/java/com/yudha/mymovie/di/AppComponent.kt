package com.yudha.mymovie.di

import com.yudha.mymovie.view.MainActivityViewModel
import com.yudha.mymovie.view.movie.MovieActivityViewModel
import dagger.Component

/**
 * Created by yudha on 16,July,2019
 */
@Component(modules = [(NetworkModule::class)])
interface AppComponent {
    fun inject(mainActivityViewModel: MainActivityViewModel)
    fun inject(movieActivityViewModel: MovieActivityViewModel)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun networkModule(networkModule: NetworkModule): Builder
    }
}