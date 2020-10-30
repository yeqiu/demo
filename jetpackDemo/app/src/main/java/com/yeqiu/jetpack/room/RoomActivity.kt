package com.yeqiu.jetpack.room

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Update
import com.yeqiu.jetpack.R
import com.yeqiu.jetpack.utils.LogUtil
import kotlinx.android.synthetic.main.activity_room.*
import kotlin.concurrent.thread

/**
 * @project：jetpackDemo
 * @author：小卷子
 * @date 2020/9/15
 * @describe：
 * @fix：
 */
class RoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)


        val peopleDao = AppDataBase.getDataBase(this).getPeopleDao()
        val people1 = People("二狗蛋")
        val people2 = People("柱子")

        btRoomAdd.setOnClickListener {
            thread {
                people1.id = peopleDao.add(people1)
                people2.id = peopleDao.add(people2)
            }

        }

        btRoomUpdate.setOnClickListener {
            thread {
                people2.name = "狗剩"
                peopleDao.update(people2)
            }

        }


        btRoomFind.setOnClickListener {
            thread {
                val peoples = peopleDao.find()
                for (people in peoples) {
                    LogUtil.log(people)
                }
            }


        }

        btRoomDelete.setOnClickListener {
            thread {
                peopleDao.delete(people2)
            }

        }

        btRoomDeleteAll.setOnClickListener {
            thread {
                peopleDao.deleteAll()
            }

        }


    }
}