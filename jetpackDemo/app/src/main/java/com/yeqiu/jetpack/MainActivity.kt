package com.yeqiu.jetpack

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.yeqiu.jetpack.lifecycle.LifecycleActivity
import com.yeqiu.jetpack.livedata.LiveDataActivity
import com.yeqiu.jetpack.navigation.NavigationActivity
import com.yeqiu.jetpack.room.RoomActivity
import com.yeqiu.jetpack.viewmodel.ViewModelActivity
import com.yeqiu.jetpack.workmanager.WorkManagerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


     private var data = ArrayList<ActivityData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

    }

    private fun init() {


        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        rvMain.layoutManager = layoutManager

        data.add(ActivityData("Lifecycle", LifecycleActivity::class.java))
        data.add(ActivityData("Navigation", NavigationActivity::class.java))
        data.add(ActivityData("ViewModel", ViewModelActivity::class.java))
        data.add(ActivityData("LiveData", LiveDataActivity::class.java))
        data.add(ActivityData("Room", RoomActivity::class.java))
        data.add(ActivityData("WorkManager", WorkManagerActivity::class.java))

        val mainAdapter = MainAdapter(data)
        rvMain.adapter = mainAdapter


    }


    data class ActivityData(val name: String, val clazz: Class<out Activity>) {

    }


}