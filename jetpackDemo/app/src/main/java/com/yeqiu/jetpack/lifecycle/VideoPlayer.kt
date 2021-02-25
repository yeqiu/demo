package com.yeqiu.jetpack.lifecycle


import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.yeqiu.jetpack.utils.ToastUtil

class VideoPlayer : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun init() {
        ToastUtil.show("VideoPlayer初始化")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun startPlay() {
        ToastUtil.show("VideoPlayer开始播放")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun stopPlay() {
        ToastUtil.show("VideoPlayer停止播放")
    }

}