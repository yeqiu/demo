package com.yeqiu.jetpack

import android.app.Application
import android.content.Context

/**
 * @project：jetpackDemo
 * @author：小卷子
 * @date 2020/9/2
 * @describe：
 * @fix：
 */
class App :Application() {

    companion object{
        lateinit var context:Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }


}