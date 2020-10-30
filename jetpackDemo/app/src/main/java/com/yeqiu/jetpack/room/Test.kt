package com.yeqiu.jetpack.room

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @project：jetpackDemo
 * @author：小卷子
 * @date 2020/9/15
 * @describe：
 * @fix：
 */
@Entity
class Test(var name: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}