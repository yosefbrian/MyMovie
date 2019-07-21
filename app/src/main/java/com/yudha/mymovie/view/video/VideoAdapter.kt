package com.yudha.mymovie.view.video

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.yudha.mymovie.R
import com.yudha.mymovie.data.model.Video
import com.yudha.mymovie.data.model.VideoResult
import com.yudha.mymovie.utils.VID_URL

/**
 * Created by yudha on 19,July,2019
 */
class VideoAdapter: RecyclerView.Adapter<VideoAdapter.ViewHolder>() {
    private var response = Video()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_video, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = response.results.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val video = response.results.get(p1)
        p0.updateView(video)
    }

    fun updateData(video: Video){
        this.response = video
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val title: TextView = itemView.findViewById(R.id.title)
        private val linItem: LinearLayout = itemView.findViewById(R.id.linItem)
        fun updateView(video: VideoResult){
            title.text = video.name

            linItem.setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(VID_URL + video.key)
                itemView.context.startActivity(i)
            }
        }
    }
}