package com.yeqiu.jetpack.viewmodel

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.yeqiu.jetpack.R
import com.yeqiu.jetpack.utils.SpUtil
import kotlinx.android.synthetic.main.activity_view_model.*

class ViewModelActivity : AppCompatActivity() {


    lateinit var viewModelDemo1: ViewModelDemo1
    lateinit var viewModelDemo2: ViewModelDemo2
    private val key = "count2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        initViewModel()
        showCount()
        initListener()

    }


    private fun initViewModel() {



        viewModelDemo1 = ViewModelProvider(this).get(ViewModelDemo1::class.java)

        val countViewModelFactory = CountViewModelFactory(SpUtil.getInt(key))
        viewModelDemo2 = ViewModelProvider(this, countViewModelFactory)
            .get(ViewModelDemo2::class.java)

    }

    private fun showCount() {
        tvCount1.text = viewModelDemo1.count.toString()

        tvCount2.text = viewModelDemo2.count.toString()
    }

    private fun initListener() {
        btAdd1.setOnClickListener {
            viewModelDemo1.count = viewModelDemo1.count + 1
            showCount()
        }

        btAdd2.setOnClickListener {
            viewModelDemo2.count = viewModelDemo2.count + 1
            showCount()
        }
    }


    override fun onPause() {
        super.onPause()
        SpUtil.putInt(key, viewModelDemo2.count)
    }

}