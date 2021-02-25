package com.yeqiu.jetpack.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.yeqiu.jetpack.utils.LogUtil

class TestServiceObserver : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onCreate() {
        LogUtil.log("TestServiceObserver.onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
        LogUtil.log("TestServiceObserver.onDestroy")
    }

}