package com.biz.hello.model

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

interface MemoDao {

    @Query(value = "select * from tbl_memo")
    open fun selectAll() : LiveData<MutableList<MemoVO>>
    
    @Query(value = "select * from tbl_memo where id = :id")
    open fun findById(id : Long) : MemoVO

    //
    // 새로운 데이터이면 insertㅡㄹㄹ 수행하고 아니면 update를 수행하라
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    open fun save(memoVO: MemoVO)
    
    @Update
    open fun update(memoVO: MemoVO)
    
    @Query(value = "delete from tbl_memo where id = :id")
    open fun delete(id: Long)
}