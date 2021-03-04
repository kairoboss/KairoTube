package com.kairat.kairotube.ui.activities.tryconnection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kairat.kairotube.R
import com.kairat.kairotube.ui.activities.playlists.PlaylistsActivity
import com.kairat.kairotube.utils.isConnected
import kotlinx.android.synthetic.main.activity_check_connection.*

class CheckConnectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_connection)
        try_again_button.setOnClickListener {
            if (this.isConnected()) {
                val intent = Intent(this, PlaylistsActivity::class.java)
                startActivity(intent)
                finish()
            } else return@setOnClickListener
        }
    }
}