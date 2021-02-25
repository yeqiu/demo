package com.yeqiu.jetpack

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.lifecycle.ProcessLifecycleOwner
import com.yeqiu.jetpack.lifecycle.AppObserver

/**
 * @project：jetpackDemo
 * @author：小卷子
 * @date 2020/9/2
 * @describe：
 * @fix：
 */
class App : Application() {

    lateinit var appObserver: AppObserver

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        appObserver = AppObserver()
        ProcessLifecycleOwner.get().lifecycle.addObserver(appObserver)
    }

}