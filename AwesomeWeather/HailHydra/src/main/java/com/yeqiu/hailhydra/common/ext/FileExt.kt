package com.yeqiu.hailhydra.common.ext

import java.io.File


/**
 * @project：HailHydra
 * @author：小卷子
 * @date 2019-11-11
 * @describe：Boolean的扩展
 * @fix：
 */

/**
 * 确保是文件夹
 * @param
 */
fun File.ensureDir(): Boolean {

    return try {
        if (isDirectory) {
            if (isFile) {
                delete()
            }
        }
        mkdir()
    } catch (e: Exception) {
        e.printStackTrace()
        false

    }
}