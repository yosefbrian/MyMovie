package com.yudha.mymovie.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by yudha on 15,July,2019
 */
class VideoResult(
    @Expose
    var author: String,
    @Expose
    var content: String,
    @Expose
    var id: String,
    @Expose
    var url: String
)