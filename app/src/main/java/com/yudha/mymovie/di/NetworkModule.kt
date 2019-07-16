package com.yudha.mymovie.di

import com.yudha.mymovie.network.MovieDbServices
import com.yudha.mymovie.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by yudha on 16,July,2019
 */

@Module
object NetworkModule {

    @Provides
    @Reusable
    @JvmStatic
    fun provideRetrofitInterface(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }

    @Provides
    @Reusable
    @JvmStatic
    fun provideMovieDbServices(retrofit: Retrofit): MovieDbServices {
        return retrofit.create(MovieDbServices::class.java)
    }
}