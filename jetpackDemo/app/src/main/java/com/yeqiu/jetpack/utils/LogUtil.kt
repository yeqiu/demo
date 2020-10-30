package com.yeqiu.jetpack.utils

import android.util.Log
import com.google.gson.Gson

/**
 * @project：jetpackDemo
 * @author：小卷子
 * @date 2020/9/2
 * @describe：
 * @fix：
 */
object LogUtil {


    fun log(msg:String){

        Log.i("jetPack",  msg)
    }

    fun  log (msg:Any){

        val json = Gson().toJson(msg)
        log(json)
    }


}