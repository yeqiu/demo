package com.yeqiu.jetpack.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @project：jetpackDemo
 * @author：小卷子
 * @date 2020/9/10
 * @describe：
 * @fix：
 */
class LiveDataViewModel : ViewModel() {

    val countLive: LiveData<Int>
        get() = _countLive

    private val _countLive = MutableLiveData<Int>()


    init {
        _countLive.value = 10
    }

    fun add() {
        val count = _countLive.value ?: 0
        _countLive.value = count + 1
    }

}