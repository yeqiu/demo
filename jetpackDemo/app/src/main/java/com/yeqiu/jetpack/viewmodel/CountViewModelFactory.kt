package com.yeqiu.jetpack.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @project：jetpackDemo
 * @author：小卷子
 * @date 2020/9/2
 * @describe：
 * @fix：
 */

class CountViewModelFactory(private val count: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelDemo2(count) as T
    }

}