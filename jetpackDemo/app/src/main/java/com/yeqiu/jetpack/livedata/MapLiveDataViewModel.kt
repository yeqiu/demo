package com.yeqiu.jetpack.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * @project：jetpackDemo
 * @author：小卷子
 * @date 2020/9/14
 * @describe：
 * @fix：
 */
class MapLiveDataViewModel : ViewModel() {

    //当userName发生变化回调

    private val userLiveData = MutableLiveData<User>()


    val userName: LiveData<String> = Transformations.map(userLiveData) { user ->
        user.name
    }

    fun setUser(user: User) {
        userLiveData.value = user
    }

}