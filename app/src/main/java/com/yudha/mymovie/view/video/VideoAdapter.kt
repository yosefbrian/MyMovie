package com.yudha.mymovie.view.video

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.yudha.mymovie.R
import com.yudha.mymovie.model.Video
import com.yudha.mymovie.model.VideoResult
import com.yudha.mymovie.utils.VideoClickListener

/**
 * Created by yudha on 19,July,2019
 */
class VideoAdapter: RecyclerView.Adapter<VideoAdapter.ViewHolder>() {
    private var response = Video()
    private var clickListener: VideoClickListener? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_video, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = response.results.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val video = response.results.get(p1)
        p0.updateView(video)
        p0.itemView.setOnClickListener {
            clickListener?.onClick(video.key)
        }
    }

    fun updateData(video: Video, clickListener: VideoClickListener){
        this.response = video
        this.clickListener = clickListener
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.title)
        fun updateView(video: VideoResult){
            title.text = video.name
        }
    }
}