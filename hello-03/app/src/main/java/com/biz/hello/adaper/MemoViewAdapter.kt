package com.biz.hello.adaper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.biz.hello.R
import com.biz.hello.model.MemoVO

class MemoViewAdapter(var context : Context, var memoList : MutableList<MemoVO>) : RecyclerView.Adapter<MemoViewAdapter.MemoHolder?>() {

    // 생성자를 클래스 생성자로 선언하면
    // 별도로 private 로 선언하지 않는다
    // 자동으로 생성이 되기 때문에
    // 그리고 이 변수를 클래스 내ㅔㅇ서 사용할때는 null값을 체크할 필오가 없어진다
    // private var memoList : MutableList<MemoVO>

    fun setList(memoList: MutableList<MemoVO>) {
        this.memoList = memoList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoHolder {

        //
        //
        val view: View = LayoutInflater
                        .from(context)
                        .inflate(R.layout.memo_item,parent,false)

        // return new 
        // 
        return MemoHolder(view)
    }

    // 생성된 를 list의 item개수만큼 복제하여 들을 생성한다
    // 이 method는 list의 item개수만큼 반복 실행되면서 Holder들을 생성하고 RecyclerView에 보여지도록 한다
    //
    override fun onBindViewHolder(holder: MemoHolder, position: Int) {
        // holder.txtDate.setDate(memoList.get(position).getDate())
        holder.txtDate.text = memoList[position]?.date.toString()
        holder.txtTime.text = memoList[position]?.time.toString()
        holder.txtMemo.text = memoList[position]?.memo.toString()
    }

    override fun getItemCount(): Int {
        return memoList.size
    }

    inner class MemoHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var txtDate : TextView = itemView.findViewById(R.id.txt_date)
        var txtTime : TextView = itemView.findViewById(R.id.txt_time)
        var txtMemo : TextView = itemView.findViewById(R.id.txt_memo_item)
    }

}