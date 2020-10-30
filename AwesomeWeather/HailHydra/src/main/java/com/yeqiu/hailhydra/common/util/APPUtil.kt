package com.yeqiu.hailhydra.common.util

import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.text.TextUtils
import com.yeqiu.hailhydra.HailHydra
import java.io.File

/**
 * @project：HailHydra
 * @author：小卷子
 * @date 2020/9/24
 * @describe：
 * @fix：
 */
object APPUtil {

   private val context = HailHydra.context


    /**
     * 获取应用名
     * @return String
     */
    fun getAppName(): String {

        var name = "unKnown"
        try {
            val packageManager = context.packageManager
            val packageInfo = packageManager.getPackageInfo(context.packageName, 0)
            val labelRes = packageInfo.applicationInfo.labelRes
            name = context.resources.getString(labelRes)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return name

    }


    /**
     * 获取渠道名
     *
     * @return
     */
    fun getChannelName(): String {
        var channelName: String = ""
        try {
            val packageManager: PackageManager = context.getPackageManager()
            //注意此处为ApplicationInfo 而不是 ActivityInfo,
            // 因为友盟设置的meta-data是在application标签中，而不是某activity标签中，所以用ApplicationInfo
            val applicationInfo = packageManager.getApplicationInfo(
                context.packageName,
                PackageManager.GET_META_DATA
            )
            if (applicationInfo.metaData != null) {
                channelName = applicationInfo.metaData["CHANNEL_NAME"].toString()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return channelName
    }

    /**
     * 获取版本名
     */
    fun getVersionName(): String {
        var versionName = ""
        try {
            val packageManager: PackageManager = context.getPackageManager()
            val packInfo: PackageInfo = packageManager.getPackageInfo(context.getPackageName(), 0)
            versionName = packInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            versionName = "unKnown"
        }
        return versionName
    }

    /**
     * 获取版本号
     *
     * @return
     */
    fun getVersionCode(): Int {
        var versionCodeInt = 0
        try {
            val packageInfo: PackageInfo = context.getApplicationContext()
                .packageManager
                .getPackageInfo(context.packageName, 0)
            versionCodeInt = packageInfo.versionCode
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return versionCodeInt
    }

    /**
     * 获取包名
     *
     * @return
     */
    fun getPackageName(): String {
        var packageName = ""

        try {
            packageName = context.packageManager
                .getPackageInfo(context.packageName, 0).packageName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            packageName = "unKnown"
        }
        return packageName
    }

    /**
     * 获取应用大小
     *
     * @return
     */
    fun getAppSize(): Long {
        var appSize: Long = 0
        try {
            val applicationInfo: ApplicationInfo =
                context.packageManager.getApplicationInfo(getPackageName(), 0)
            appSize = File(applicationInfo.sourceDir).length()
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return appSize
    }

    /**
     * 提取应用apk文件
     *
     * @return
     */
    fun getAppApk(): String? {
        var sourceDir: String? = null
        try {
            val applicationInfo: ApplicationInfo =
                context.packageManager.getApplicationInfo(getPackageName(), 0)
            sourceDir = applicationInfo.sourceDir
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return sourceDir
    }


    /**
     * 应用是否指定安装
     *
     * @param packageName
     * @return
     */
    fun isInstalled(packageName: String): Boolean {
        var installed = false
        if (TextUtils.isEmpty(packageName)) {
            return false
        }
        val installedApplications: List<ApplicationInfo> = context.getPackageManager()
            .getInstalledApplications(0)
        for (`in` in installedApplications) {
            if (packageName == `in`.packageName) {
                installed = true
                break
            } else {
                installed = false
            }
        }
        return installed
    }


    /**
     * 获取包名最后一个节点名
     *
     * @return
     */
    fun getPackageNameLast(): String {
        val split = getPackageName().split("\\.".toRegex()).toTypedArray()
        return if (split.isNotEmpty()) {
            split[split.size - 1]
        } else ""

    }


}


