package com.kairat.kairotube.ui.activities.playlists

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.kairat.kairotube.App
import com.kairat.kairotube.data.model.VideoInfo

class PlaylistsViewModel : ViewModel() {

    var playlists = MutableLiveData<MutableList<VideoInfo.Info>>()
    fun setPlaylists(){
        playlists = App.repository.loadPlaylists()
    }
}