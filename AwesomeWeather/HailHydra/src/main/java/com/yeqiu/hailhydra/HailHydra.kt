package com.yeqiu.hailhydra

import android.app.Application
import android.content.Context
import com.yeqiu.hailhydra.common.util.LogUtils

/**
 * @project：HailHydra
 * @author：小卷子
 * @date 2020/9/24
 * @describe：
 * @fix：
 */

object HailHydra {


    lateinit var hailHydra: HailHydra
    lateinit var context: Context
    var isDebug: Boolean = false

     fun init(app: Application) {

        hailHydra = this
        context = app.applicationContext


         LogUtils.init()


    }


    fun isDebug(debug: Boolean){
        isDebug = debug

    }





}