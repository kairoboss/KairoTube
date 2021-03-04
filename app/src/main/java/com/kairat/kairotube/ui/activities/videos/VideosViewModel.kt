package com.kairat.kairotube.ui.activities.videos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kairat.kairotube.App
import com.kairat.kairotube.data.model.VideoInfo

class VideosViewModel : ViewModel() {

    var videos = MutableLiveData<MutableList<VideoInfo.Info>>()

    fun setVideos(id:String){
        videos = App.repository.loadVideos(id)
    }
}