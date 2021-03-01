package com.kairat.kairotube.data.remote

import com.kairat.kairotube.data.model.VideoInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {
    @GET("playlists")
    fun getPlaylists(@Query("part") part: String,
                     @Query("channelId")channelId: String,
                     @Query("key") apiKey:String)
            : Call<VideoInfo>


}