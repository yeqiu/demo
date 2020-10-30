package com.yeqiu.awesomeweather.viewmodel.area

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.yeqiu.awesomeweather.data.model.Place
import com.yeqiu.awesomeweather.data.repository.PlaceRepository
import java.util.*

/**
 * @project：AwesomeWeather
 * @author：小卷子
 * @date 2020/10/13
 * @describe：
 * @fix：
 */
class PlaceViewModel : ViewModel() {


    private val searchPlace = MutableLiveData<String>()
    //用于缓存数据，外界可直接调用这个集合获取数据
    val placeList = ArrayList<Place>()

    //观察当searchPlace发生变化，从仓库中获取新的数据
    val placeLiveData = Transformations.switchMap(searchPlace) { query ->
        PlaceRepository.searchPlaces(query)
    }

    //改变searchPlace
    fun searchPlace(query: String) {
        searchPlace.value = query
    }


}