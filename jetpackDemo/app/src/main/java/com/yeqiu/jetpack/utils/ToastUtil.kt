package com.yeqiu.jetpack.utils

import android.widget.Toast
import com.yeqiu.jetpack.App

/**
 * @project：jetpackDemo
 * @author：小卷子
 * @date 2020/9/2
 * @describe：
 * @fix：
 */
object ToastUtil {

    fun show(msg: String) {


        Toast.makeText(App.context, msg, Toast.LENGTH_SHORT).show();
    }

}