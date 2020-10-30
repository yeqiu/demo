package com.yeqiu.awesomeweather.app

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.yeqiu.hailhydra.HailHydra

/**
 * @project：AwesomeWeather
 * @author：小卷子
 * @date 2020/9/24
 * @describe：
 * @fix：
 */
class AwesomeWeather : Application() {


    companion object {
        lateinit var context: Context
    }


    override fun onCreate() {
        super.onCreate()
        context = applicationContext

        init()
    }

    private fun init() {
        HailHydra.init(this)
    }
}