package com.yeqiu.jetpack.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.yeqiu.jetpack.App

/**
 * @project：jetpackDemo
 * @author：小卷子
 * @date 2020/9/2
 * @describe：
 * @fix：
 */
object SpUtil {

    private fun getSp(): SharedPreferences {
        return App.context.getSharedPreferences("jetpack_demo", Context.MODE_PRIVATE)
    }


    fun putInt( key: String,value: Int) {

        getSp().edit {
            putInt(key, value)
        }
    }

    fun getInt(key: String): Int {
        return getSp().getInt(key, 0)
    }


}