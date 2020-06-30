package com.example.kotlin._12kotlin.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin.R
import com.example.kotlin._12kotlin.FruitActivity
import com.example.kotlin._12kotlin.enity.Fruit
import com.example.kotlin.startActivity
import com.example.kotlin.startActivity2


class SwipeRefreshAdapter() : RecyclerView.Adapter<SwipeRefreshAdapter.ViewHolder>() {
    lateinit var context: Context
    lateinit var fruitList: ArrayList<Fruit>

    constructor(context: Context, fruitList: ArrayList<Fruit>) : this() {
        this.context = context
        this.fruitList = fruitList

    }
    override fun getItemCount(): Int {
        return fruitList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.kotlin_12_material_cardview_fruit_item, parent, false)
        val holder = ViewHolder(view)

        // 点击 事件 1
        holder.image.setOnClickListener {
            val position = holder.adapterPosition
            val fruit = fruitList[position]

            val intent = Intent(context, FruitActivity::class.java).apply {
                //apply  lambda 表达式中含有 调用者对象 的 上下文， 并 返回一个调用者对象
                putExtra(FruitActivity.FRUIT_NAME, fruit.name)
                putExtra(FruitActivity.FRUIT_IMG_ID, fruit.imageId)
            }
            context.startActivity(intent)

        }
        return holder
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.text.text = fruit.name
        Glide.with(context).load(fruit.imageId).into(holder.image)

        // 点击 事件 2
        holder.text.setOnClickListener {
            Toast.makeText(context,"点击的 是text", Toast.LENGTH_SHORT).show()
            startActivity2<FruitActivity>(context) {
                putExtra(FruitActivity.FRUIT_NAME, fruit.name)
                putExtra(FruitActivity.FRUIT_IMG_ID, fruit.imageId)
            }
        }

    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text: TextView = view.findViewById(R.id.fruitName)
        val image: ImageView = view.findViewById(R.id.fruitImage)
    }
}