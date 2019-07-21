package com.yudha.mymovie.data.model

import com.google.gson.annotations.Expose


/**
 * Created by yudha on 15,July,2019
 */
data class ReviewResult (
    @Expose
    var author: String,
    @Expose
    var content: String,
    @Expose
    var id: String,
    @Expose
    var url: String
)