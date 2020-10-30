package com.yeqiu.hailhydra.network

import com.yeqiu.hailhydra.network.interceptor.LoggingInterceptor
import com.yeqiu.hailhydra.network.interceptor.NetInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * @project：AwesomeWeather
 * @author：小卷子
 * @date 2020/10/12
 * @describe：
 * @fix：
 */
object ServiceFactory {

    private const val BASE_URL = "https://api.caiyunapp.com/"


    private var loggingInterceptor = LoggingInterceptor.Builder()
        .loggable(true)
        .request()
        .requestTag("Request")
        .response()
        .responseTag("Response")
        .hideVerticalLine()// 隐藏竖线边框
        .build()


    private val okHttpClient = OkHttpClient.Builder()
        .writeTimeout(30 * 1000, TimeUnit.MILLISECONDS)
        .readTimeout(30 * 1000, TimeUnit.MILLISECONDS)
        .connectTimeout(30 * 1000, TimeUnit.MILLISECONDS)
        .addInterceptor(NetInterceptor())
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()


    fun <T> create(service: Class<T>): T {

        return retrofit.create(service)
    }

    inline fun <reified T> create(): T = create(T::class.java)

}