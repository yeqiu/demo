package com.yeqiu.jetpack.room

import androidx.room.*

/**
 * @project：jetpackDemo
 * @author：小卷子
 * @date 2020/9/15
 * @describe：
 * @fix：
 */
@Dao
interface PeopleDao {

    @Insert
    fun add(people: People): Long

    @Update
    fun update(people: People)

    @Query("select * from People")
    fun find(): List<People>

    @Delete
    fun delete(people: People)

    @Query("delete from People")
    fun deleteAll(): Int

}