package com.yeqiu.hailhydra.network.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * @project：AwesomeWeather
 * @author：小卷子
 * @date 2020/10/15
 * @describe：
 * @fix：
 */
class NetInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        
        val builder: Request.Builder = chain.request().newBuilder()
        val request: Request = builder.build()
        var response: Response = chain.proceed(request)


        // TODO: 2020/10/15  回调request和response给业务处理


        //添加公共请求头，公共参数

        //校验登录是否失败





        return response

    }

    


}