package com.yeqiu.awesomeweather.data.network.service

import com.yeqiu.awesomeweather.data.constant.AppData
import com.yeqiu.awesomeweather.data.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @project：AwesomeWeather
 * @author：小卷子
 * @date 2020/10/12
 * @describe：
 * @fix：
 */
interface PlaceService {

    @GET("/v2/place?token=${AppData.weatherKey}&lang=zh_CN")
    fun searchPlaces(@Query("query") place:String):Call<PlaceResponse>

}