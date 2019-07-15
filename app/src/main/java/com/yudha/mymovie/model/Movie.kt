package com.yudha.mymovie.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by yudha on 15,July,2019
 */
data class Movie(
    @Expose
    var result: List<MovieResult>,
    @SerializedName("total_results")
    var totalResults: Int,
    @SerializedName("total_pages")
    var totalPages: Int,
    @Expose
    var pages: Int
)