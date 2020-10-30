package com.yeqiu.jetpack.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * @project：jetpackDemo
 * @author：小卷子
 * @date 2020/9/14
 * @describe：
 * @fix：
 */
object UserRepository {

    fun getUser(id:Int):LiveData<User>{

        val liveData = MutableLiveData<User>()
        liveData.value = User(id,"狗蛋$id")
        return liveData
    }

}