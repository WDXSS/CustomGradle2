package com.example.kotlin._4kotlin.adater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.R
import com.example.kotlin._4kotlin.entity.FruitEntity

class RecyclerViewFruitAdapter(private val fruitList: List<FruitEntity>) : RecyclerView.Adapter<RecyclerViewFruitAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.kotlin_4_adapter_fruit_item,parent,false)
        val  viewHolder = ViewHolder(view)
        //item 的点击事件
        viewHolder.itemView.setOnClickListener {
            val position =  viewHolder.adapterPosition
            val fruit = fruitList[position]
            Toast.makeText(parent.context, "you clicked view ${fruit.name}", Toast.LENGTH_SHORT).show()
        }
        viewHolder.fruitImage.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = fruitList[position]
            Toast.makeText(parent.context, "you clicked image ${fruit.name}", Toast.LENGTH_SHORT).show()
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val fruitEntity = fruitList[position]
        holder.fruitImage.setImageResource(fruitEntity.imageId)
        holder.fruitName.text = fruitEntity.name
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //注意 变量后 后面的  : 类型
        val fruitImage :ImageView = itemView.findViewById(R.id.fruitImage)
        val fruitName :TextView = itemView.findViewById(R.id.fruitName)
    }
}