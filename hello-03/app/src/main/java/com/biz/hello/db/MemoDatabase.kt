package com.biz.hello.db

import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.biz.hello.model.MemoDao
import com.biz.hello.model.MemoVO
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(entities = [MemoVO::class],version = 1,exportSchema = false)
abstract class MemoDatabase : RoomDatabase() {

    abstract val memoDao : MemoDao

    companion object {

        private var INSTANCE : MemoDatabase? = null
        private val NUMBER_THREADS = 5

        val databaseWriterExecutor : ExecutorService = Executors.newFixedThreadPool(NUMBER_THREADS)
        fun getInstance(context: Context) : MemoDatabase? {

            if(INSTANCE == null) {
                synchronized(MemoDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    MemoDatabase::class.java,"memo_databasw").build()
                }
            }
            return INSTANCE
        }
    }
}