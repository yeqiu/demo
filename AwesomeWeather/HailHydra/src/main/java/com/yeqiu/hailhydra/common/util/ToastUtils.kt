package com.yeqiu.hailhydra.common.util

import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.widget.Toast
import com.yeqiu.hailhydra.HailHydra


/**
 * @project：HailHydra
 * @author：小卷子
 * @date 2020/9/24
 * @describe：
 * @fix：
 */
object ToastUtils {

    private val context = HailHydra.context
    private var oldMsg: String? = null
    private var time: Long = 0

    fun showToast(msg: String) {
        if (TextUtils.isEmpty(msg)) {
            return
        }
        // 当显示的内容不一样时，即断定为不是同一个Toast
        if (msg != oldMsg) {
            val toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT)
            toast.setText(msg)
            show(toast)
            time = System.currentTimeMillis()
        } else {
            // 显示内容一样时，只有间隔时间大于2秒时才显示
            if (System.currentTimeMillis() - time > 2000) {
                val toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT)
                toast.setText(msg)
                show(toast)
                time = System.currentTimeMillis()
            }
        }
        oldMsg = msg
    }


    private fun show(toast: Toast) {

        if (Looper.myLooper() == Looper.getMainLooper()) {
            toast.show()
        } else{
            //切换到主线程显示
            val mainHandler = Handler(Looper.getMainLooper())
            mainHandler.post {
                toast.show()
            }

        }
    }
}


fun String.showToast(duration:Int = Toast.LENGTH_SHORT){

    ToastUtils.showToast(this)

}

fun Int.showToast(duration:Int = Toast.LENGTH_SHORT){

    ToastUtils.showToast(this.toString())

}




