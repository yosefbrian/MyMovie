package com.yudha.mymovie.model

import com.google.gson.annotations.Expose

/**
 * Created by yudha on 16,July,2019
 */
data class Genre (
    @Expose
    var genres: List<GenreResult> = ArrayList()
)