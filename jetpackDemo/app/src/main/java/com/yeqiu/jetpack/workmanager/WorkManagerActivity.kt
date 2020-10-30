package com.yeqiu.jetpack.workmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.yeqiu.jetpack.R
import kotlinx.android.synthetic.main.activity_work_manager.*
import java.util.concurrent.TimeUnit

/**
 * @project：jetpackDemo
 * @author：小卷子
 * @date 2020/9/18
 * @describe：
 * @fix：
 */
class WorkManagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)


        val oneTimeWorkRequest = OneTimeWorkRequest.Builder(SimpleWorker::class.java).build()

        val periodicWorkRequest =
            PeriodicWorkRequest.Builder(SimpleWorker::class.java, 15, TimeUnit.MINUTES).build()



        btOneWork.setOnClickListener {
            WorkManager.getInstance(this).enqueue(oneTimeWorkRequest)
        }
        btPeriodicWork.setOnClickListener {
            WorkManager.getInstance(this).enqueue(periodicWorkRequest)
        }


    }
}