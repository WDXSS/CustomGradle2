package com.example.kotlin._4kotlin.adater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.R
import com.example.kotlin._4kotlin.entity.Msg

class MsgAdapter(val msgList: List<Msg>) : RecyclerView.Adapter<MsgViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MsgViewHolder {
        val holder: MsgViewHolder
        holder = if (viewType == Msg.TYPE_RECEIVED) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.kotlin_4_msg_left_item, parent, false)
            LeftViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.kotlin_4_msg_right_item, parent, false)
            RightViewHolder(view)
        }

        when(viewType){
            Msg.TYPE_RECEIVED ->{
                println("LeftViewHolder------------")
            }
            Msg.TYPE_SENT ->{
                println("RightViewHolder------------")
            }
        }
        return holder

    }

    override fun getItemCount(): Int {
        return msgList.size
    }

    override fun getItemViewType(position: Int): Int {
        return msgList[position].type
    }

    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        val msg = msgList[position]
        // 封闭类的作用 可以不用写 else 了， 原因查看 MsgViewHolder
        when (holder) {
             is LeftViewHolder -> holder.leftMsg.text = msg.content
            is RightViewHolder -> holder.rightMsg.text = msg.content
        }
    }

}