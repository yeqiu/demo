package com.yeqiu.jetpack.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.yeqiu.jetpack.utils.LogUtil
import com.yeqiu.jetpack.utils.ToastUtil

/**
 * @project：jetpackDemo
 * @author：小卷子
 * @date 2020/9/18
 * @describe：
 * @fix：
 */
class SimpleWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        LogUtil.log("SimpleWorker")
        return Result.success()
    }
}