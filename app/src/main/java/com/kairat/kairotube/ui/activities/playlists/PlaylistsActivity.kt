package com.kairat.kairotube.ui.activities.playlists

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.VISIBLE
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kairat.kairotube.R
import com.kairat.kairotube.ui.activities.tryconnection.CheckConnectionActivity
import com.kairat.kairotube.ui.activities.videos.VideosActivity
import com.kairat.kairotube.ui.adapters.PlaylistsAdapter
import com.kairat.kairotube.ui.listener.OnItemClickListener
import com.kairat.kairotube.utils.isConnected
import kotlinx.android.synthetic.main.activity_playlists.*

class PlaylistsActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var model : PlaylistsViewModel

    private lateinit var adapter:PlaylistsAdapter

    private var layoutManager:LinearLayoutManager = LinearLayoutManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlists)
        if (!this.isConnected()){
            val intent = Intent(this, CheckConnectionActivity::class.java)
            startActivity(intent)
            finish()
        }

        model = ViewModelProvider(this)[PlaylistsViewModel::class.java]
        initAdapter()
        model.setPlaylists()
        model.playlists.observe(this, Observer {
            adapter.addItems(it!!)
        })
    }

    private fun initAdapter() {
        adapter = PlaylistsAdapter(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        playlists_rv.layoutManager = layoutManager
        playlists_rv.itemAnimator = DefaultItemAnimator()
        playlists_rv.adapter = adapter
        playlists_rv.isNestedScrollingEnabled = true
    }

    override fun onItemClick(pos: Int) {
        var intent = Intent(this, VideosActivity::class.java)
        intent.putExtra("playlistId",adapter.getItem(pos).id )
        intent.putExtra("title", adapter.getItem(pos).snippet?.title)
        intent.putExtra("description", adapter.getItem(pos).snippet?.description)
        intent.putExtra("video_count", adapter.getItem(pos).contentDetails?.itemCount)
        startActivity(intent)
    }
}