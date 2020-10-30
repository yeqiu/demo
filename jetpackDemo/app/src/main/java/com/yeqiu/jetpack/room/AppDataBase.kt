package com.yeqiu.jetpack.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * @project：jetpackDemo
 * @author：小卷子
 * @date 2020/9/15
 * @describe：
 * @fix：
 */
@Database(version = 2, entities = [People::class, Test::class])
abstract class AppDataBase : RoomDatabase() {

    abstract fun getPeopleDao(): PeopleDao

    companion object {
        private var instant: AppDataBase? = null


        val sql = "create table test (id integer primary key " +
                "autoincrement not null , name text not null)"


        val update = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(sql)
            }

        }


        @Synchronized
        fun getDataBase(context: Context): AppDataBase {
            instant?.let {
                return it
            }
            return Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java, "jetpack_database"
            )
                .addMigrations(update)
                .build().apply {
                    instant = this;
                }
        }
    }
}