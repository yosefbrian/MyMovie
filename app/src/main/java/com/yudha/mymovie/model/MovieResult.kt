package com.yudha.mymovie.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by yudha on 15,July,2019
 */
data class MovieResult (
    @Expose
    var id: Int,
    @Expose
    var overview: String,
    @SerializedName("original_language")
    var originalLanguage: String,
    @SerializedName("original_title")
    var originalTitle: String,
    @Expose
    var video: Boolean,
    @Expose
    var title: String,
    @SerializedName("genre_ids")
    var genreIds: List<Int>,
    @SerializedName("poster_path")
    var posterPath: String,
    @SerializedName("backdrop_path")
    var backdropPath: String,
    @SerializedName("release_date")
    var releaseDate: String,
    @SerializedName("vote_average")
    var voteAverage: Double,
    @Expose
    var popularity: Double,
    @Expose
    var adult: Boolean,
    @SerializedName("vote_count")
    var voteCount: Double
)