package com.yudha.mymovie.data.model

import com.google.gson.annotations.Expose


/**
 * Created by yudha on 15,July,2019
 */
class VideoResult(
    @Expose
    var author: String,
    @Expose
    var name: String,
    @Expose
    var id: String,
    @Expose
    var key: String
)