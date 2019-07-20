package com.yudha.mymovie.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by yudha on 15,July,2019
 */
data class Review (
    @Expose
    var id : Int = 0,
    @Expose
    var results: List<ReviewResult> = mutableListOf(),
    @SerializedName("total_results")
    var totalResults: Int = 0,
    @SerializedName("total_pages")
    var totalPages: Int = 0,
    @Expose
    var pages: Int = 0
)