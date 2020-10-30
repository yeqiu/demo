package com.yeqiu.awesomeweather.data.repository

import androidx.lifecycle.liveData
import com.yeqiu.awesomeweather.data.network.NetWorkManager
import kotlinx.coroutines.Dispatchers

/**
 * @project：AwesomeWeather
 * @author：小卷子
 * @date 2020/10/12
 * @describe：
 * @fix：
 */
object PlaceRepository {


    fun searchPlaces(query: String) = liveData(Dispatchers.IO){

        var result = try{
            //请求网络数据
            val placeResponse = NetWorkManager.searchPlaces(query)
            if (placeResponse.status == "ok"){
                val place = placeResponse.places
                Result.success(place)
            }else{
                Result.failure(RuntimeException("获取地区数据错误,${placeResponse.status}"))
            }


        }catch (e:Exception){
            Result.failure(e)
        }
        //设置请求的结果，类似调用setValue
        emit(result)
    }

}