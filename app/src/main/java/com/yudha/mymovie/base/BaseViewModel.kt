package com.yudha.mymovie.base

import android.arch.lifecycle.ViewModel
import com.yudha.mymovie.di.AppComponent
import com.yudha.mymovie.di.DaggerAppComponent
import com.yudha.mymovie.di.NetworkModule
import com.yudha.mymovie.view.MainActivityViewModel

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
        is MainActivityViewModel -> injector.inject(this)
        }
    }


}