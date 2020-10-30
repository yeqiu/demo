package com.yeqiu.awesomeweather.data.model

import com.google.gson.annotations.SerializedName

/**
 * @project：AwesomeWeather
 * @author：小卷子
 * @date 2020/10/12
 * @describe：
 * @fix：
 */

//定义网络数据模型

data class PlaceResponse(val status: String, val query:String,val places: List<Place>)


data class Place(
    val name: String, val location: Location,
    @SerializedName("formatted_address") val address: String
)


data class Location(val lng: String, val lat: String)


