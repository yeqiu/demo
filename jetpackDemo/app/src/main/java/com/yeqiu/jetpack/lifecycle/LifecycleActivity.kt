package com.yeqiu.jetpack.lifecycle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yeqiu.jetpack.R

class LifecycleActivity : AppCompatActivity() {


    private lateinit var videoPlayer: VideoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)

        videoPlayer = VideoPlayer()
        lifecycle.addObserver(videoPlayer)

        //开启service
        val intent = Intent(this, TestService::class.java)
        startService(intent)
    }


    override fun onDestroy() {
        super.onDestroy()
        //停止service
        val intent = Intent(this, TestService::class.java)
        stopService(intent)
    }


}