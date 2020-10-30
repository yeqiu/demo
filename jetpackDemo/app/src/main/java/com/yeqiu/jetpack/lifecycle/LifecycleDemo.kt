package com.yeqiu.jetpack.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.yeqiu.jetpack.utils.LogUtil
import com.yeqiu.jetpack.utils.ToastUtil

/**
 * @project：jetpackDemo
 * @author：小卷子
 * @date 2020/9/2
 * @describe：
 * @fix：
 */
class LifecycleDemo(var lifecycleife:Lifecycle) : LifecycleObserver {


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onActivityCreate() {
        LogUtil.log("LifecycleActivity执行了onCreate")
        ToastUtil.show("onActivityCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onActivityStart() {
        LogUtil.log("LifecycleActivity执行了onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onActivityStop() {
        LogUtil.log("LifecycleActivity执行了onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onActivityDestroy() {
        LogUtil.log("LifecycleActivity执行了onDestroy")

        ToastUtil.show("onActivityDestroy")
    }

    /**
     * 可以感知所有生命周期
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAnyActivityLife() {
        val msg = "LifecycleActivity执行了${lifecycleife.currentState}"
        LogUtil.log(msg)
    }

}