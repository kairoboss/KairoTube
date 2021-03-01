package com.kairat.kairotube.ui.activities.playlists

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.VISIBLE
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kairat.kairotube.R
import com.kairat.kairotube.ui.activities.tryconnection.TryConnectionActivity
import com.kairat.kairotube.ui.adapters.PlaylistsAdapter
import com.kairat.kairotube.utils.isConnected
import kotlinx.android.synthetic.main.activity_playlists.*

class PlaylistsActivity : AppCompatActivity() {

    private lateinit var model : PlaylistsViewModel

    private lateinit var adapter:PlaylistsAdapter

    private var layoutManager:LinearLayoutManager = LinearLayoutManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlists)
        if (!this.isConnected(this)){
            var intent = Intent(this, TryConnectionActivity::class.java)
            startActivity(intent)
        }

        model = PlaylistsViewModel()
        initAdapter()
        model.setPlaylists()
        model.playlists.observe(this, Observer {
            adapter.addItems(it!!)
        })
    }

    private fun initAdapter() {
        adapter = PlaylistsAdapter()
        layoutManager.orientation = RecyclerView.VERTICAL
        playlists_rv.layoutManager = layoutManager
        playlists_rv.itemAnimator = DefaultItemAnimator()
        playlists_rv.adapter = adapter
        playlists_rv.isNestedScrollingEnabled = true
    }
}