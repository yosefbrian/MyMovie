package com.yudha.mymovie.model

import com.google.gson.annotations.Expose

/**
 * Created by yudha on 15,July,2019
 */
data class GenreResult(
    @Expose
    var id: Int,
    @Expose
    var name: String
)