package com.yeqiu.awesomeweather.data.network

import com.yeqiu.awesomeweather.data.network.service.PlaceService
import com.yeqiu.hailhydra.network.ServiceFactory
import retrofit2.await

/**
 * @project：AwesomeWeather
 * @author：小卷子
 * @date 2020/10/12
 * @describe：
 * @fix：
 */
object NetWorkManager {

    private val placeService = ServiceFactory.create<PlaceService>()

    suspend fun searchPlaces(query: String)= placeService.searchPlaces(query).await()

}