package com.yudha.mymovie.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import com.yudha.mymovie.view.details.MovieDetailsActivity
import com.yudha.mymovie.view.details.MovieDetailsViewModel
import com.yudha.mymovie.view.genre.GenreActivity
import com.yudha.mymovie.view.genre.GenreViewModel
import com.yudha.mymovie.view.movie.MovieActivity
import com.yudha.mymovie.view.movie.MovieViewModel
import com.yudha.mymovie.view.review.ReviewActivity
import com.yudha.mymovie.view.review.ReviewViewModel
import com.yudha.mymovie.view.video.VideoActivity
import com.yudha.mymovie.view.video.VideoViewModel

/**
 * Created by yudha on 16,July,2019
 */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when(activity){
            is GenreActivity -> GenreViewModel() as T
            is MovieActivity -> MovieViewModel() as T
            is MovieDetailsActivity -> MovieDetailsViewModel() as T
            is ReviewActivity -> ReviewViewModel() as T
            is VideoActivity -> VideoViewModel() as T
            else -> throw IllegalArgumentException("VIEW MODEL NOT FOUND")
        }
    }
}