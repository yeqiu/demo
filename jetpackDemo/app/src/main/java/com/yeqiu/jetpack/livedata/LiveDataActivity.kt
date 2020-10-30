package com.yeqiu.jetpack.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yeqiu.jetpack.R
import com.yeqiu.jetpack.utils.LogUtil
import kotlinx.android.synthetic.main.activity_live_data.*

class LiveDataActivity : AppCompatActivity() {

    lateinit var viewModel: LiveDataViewModel
    lateinit var mapLiveDataViewModel: MapLiveDataViewModel
    lateinit var switchMapLiveDataViewModel: SwitchMapLiveDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        viewModel = ViewModelProvider(this).get(LiveDataViewModel::class.java)

        //观察数据
        viewModel.countLive.observe(this) { count ->
            LogUtil.log("数据发生变化 当前 count is $count")
            tvLiveDataCount.text = count.toString()
        }


        btLiveDataCount.setOnClickListener {
            viewModel.add()
        }


        mapLiveDataViewModel = ViewModelProvider(this).get(MapLiveDataViewModel::class.java)


        mapLiveDataViewModel.setUser(User(1, "二狗蛋"))


        mapLiveDataViewModel.userName.observe(this) { name ->
            tvLiveDataUserName.text = name

        }


        switchMapLiveDataViewModel =
            ViewModelProvider(this).get(SwitchMapLiveDataViewModel::class.java)

        switchMapLiveDataViewModel.user.observe(this) { user ->
            tvLiveDataUserName2.text = user.name

        }

        btChangeName.setOnClickListener {
            val id = (0..10).random()
            switchMapLiveDataViewModel.getUser(id)
        }

    }
}