package com.yudha.mymovie.network

import com.yudha.mymovie.model.*
import com.yudha.mymovie.utils.DEFAULT_PARAMS
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by yudha on 16,July,2019
 */
interface MovieDbServices {

    @GET("genre/movie/list$DEFAULT_PARAMS")
    fun getGenres() : Observable<Genre>

    @GET("discover/movie$DEFAULT_PARAMS")
    fun getMovies(@Query("with_genres") genreId: Int) : Observable<Movie>

    @GET("movie/{id}$DEFAULT_PARAMS")
    fun getMovie(@Path("id") id: Int): Observable<MovieResult>

    @GET("movie/{id}/videos$DEFAULT_PARAMS")
    fun getVideos(@Path("id") id: Int): Observable<Video>

    @GET("movie/{id}/reviews$DEFAULT_PARAMS")
    fun getReviews(@Path("id") id: Int): Observable<Review>

}