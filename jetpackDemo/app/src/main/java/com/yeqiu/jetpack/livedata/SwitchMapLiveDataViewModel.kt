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
class SwitchMapLiveDataViewModel : ViewModel() {



    //定义idLiveData观察id的变化，当id发生变化调用Transformations.switchMap
    //在switchMap通过id获取user数据。

    //工作流程:
    //当外部调用getUser时候，SwitchMapLiveDataViewModel内部并不会调用任何函数。
    //只是给idLiveData赋值。一旦当idLiveData的值发生变化就会通过
    //Transformations.switchMap来获取数据，内部最终调用了 UserRepository.getUser(id)



    private val idLiveData = MutableLiveData<Int>()


    fun getUser(id: Int) {
        idLiveData.value = id
    }

    val user: LiveData<User> = Transformations.switchMap(idLiveData) { id ->
        UserRepository.getUser(id)
    }
    






}