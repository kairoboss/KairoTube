package com.kairat.kairotube

import android.app.Application
import com.kairat.kairotube.data.repository.Repository

class App : Application() {

    companion object{
        lateinit var repository: Repository
    }

    override fun onCreate() {
        super.onCreate()
        repository = Repository()
    }


}