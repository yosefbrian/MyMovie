package com.yudha.mymovie.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import com.yudha.mymovie.view.MainActivity
import com.yudha.mymovie.view.MainActivityViewModel
import com.yudha.mymovie.view.movie.MovieActivity
import com.yudha.mymovie.view.movie.MovieActivityViewModel
import java.lang.IllegalArgumentException

/**
 * Created by yudha on 16,July,2019
 */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when(activity){
            is MainActivity -> MainActivityViewModel() as T
            is MovieActivity -> MovieActivityViewModel() as T
            else -> throw IllegalArgumentException("VIEW MODEL NOT FOUND")
        }
    }
}