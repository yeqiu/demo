package com.yeqiu.awesomeweather.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yeqiu.awesomeweather.R
import com.yeqiu.hailhydra.common.util.log


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        log("aaaaaa")

    }
}