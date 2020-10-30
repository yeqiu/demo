package com.yeqiu.hailhydra.common.util

import com.google.gson.Gson
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy


/**
 * @project：HailHydra
 * @author：小卷子
 * @date 2020/9/24
 * @describe：
 * @fix：
 */


fun log(msg: Any,tag:String = "") {

    if (msg is String) {
        Logger.t(tag).i(msg)
    } else {
        //转json处理
        val json = Gson().toJson(msg)
        Logger.t(tag).i(json)
    }
}


fun logJson(json: String) {
    Logger.json(json)
}


object LogUtils {

    private val tag = APPUtil.getAppName()

    fun init() {
        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(true)
            .methodCount(5)
            .methodOffset(0)
            .tag(tag)
            .build()


        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }

}
