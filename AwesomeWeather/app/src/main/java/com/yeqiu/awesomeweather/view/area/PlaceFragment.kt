package com.yeqiu.awesomeweather.view.area

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yeqiu.awesomeweather.R
import com.yeqiu.awesomeweather.viewmodel.area.PlaceViewModel
import com.yeqiu.hailhydra.common.util.showToast
import kotlinx.android.synthetic.main.fragment_place.*

/**
 * @project：AwesomeWeather
 * @author：小卷子
 * @date 2020/10/13
 * @describe：
 * @fix：
 */
class PlaceFragment:Fragment() {

   private val placeViewModel by lazy {
        ViewModelProvider(this).get(PlaceViewModel::class.java)
    }

    private lateinit var placeAdapter: PlaceAdapter



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_place,container,false);
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //初始化RecyclerView
        val linearLayoutManager = LinearLayoutManager(activity)
        rvPlaceList.layoutManager = linearLayoutManager
        val placeList = placeViewModel.placeList
        placeAdapter = PlaceAdapter(placeList)
        rvPlaceList.adapter = placeAdapter

        etPlace.addTextChangedListener{editable->
            val context = editable.toString()
            if (context.isNotEmpty()){
                placeViewModel.searchPlace(context)
            }else{
                //输入内容为空
                //隐藏列表，清除之前的数据
                rvPlaceList.visibility = View.INVISIBLE
                placeViewModel.placeList.clear()
            }
        }



        //列表数据回调监听
        placeViewModel.placeLiveData.observe(viewLifecycleOwner,{result->
            val placeList = result.getOrNull()

            if (placeList!=null){
                rvPlaceList.visibility = View.VISIBLE
                //设置ViewModel的数据
                placeViewModel.placeList.clear()
                placeViewModel.placeList.addAll(placeList)
                placeAdapter.notifyDataSetChanged()
            }else{
                "未能查询到任何地点".showToast()
                result.exceptionOrNull()?.printStackTrace()
            }

        })




    }

}