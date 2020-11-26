package com.biz.hello.db

import android.app.Application
import androidx.lifecycle.LiveData
import com.biz.hello.model.MemoDao
import com.biz.hello.model.MemoVO

class MemoRepository(app : Application) {

    private lateinit var memoDao : MemoDao
    private lateinit var memoList : LiveData<MutableList<MemoVO>>

    init {
        val db : MemoDatabase? = MemoDatabase.getInstance(app)
        if(db != null) {
            memoDao = db.memoDao
        }
        memoList = memoDao.selectAll()
    }

    fun selectAll() : LiveData<MutableList<MemoVO>> {
        return this.memoList
    }

    fun insert(memoVO: MemoVO) {
        //
        //
        MemoDatabase.databaseWriterExecutor.execute(Runnable {memoDao.save(memoVO)})
    }

    fun update(memoVO: MemoVO) {

        MemoDatabase.databaseWriterExecutor.execute(Runnable {memoDao.save(memoVO)})
    }

    fun delete(memoVO: MemoVO) {
        memoDao.delete(memoVO.id)
    }
}