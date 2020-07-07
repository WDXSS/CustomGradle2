package com.example.kotlin._12kotlin.adapter

import android.app.Activity
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
import com.example.kotlin._12kotlin.kotlin.showToast
import com.example.kotlin._2kotlin.DevKotlin
import com.example.kotlin.startActivity
import com.example.kotlin.startActivity2

@DevKotlin("练习 下拉刷新")
open class SwipeRefreshAdapter2(val context: Context, val fruitList: MutableList<Fruit>) : RecyclerView.Adapter<SwipeRefreshAdapter2.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //inner修饰的内部类可理解为java中的非静态内部类
        // Kotlin 中的内部类 默认是 静态的
        val adapter2 = this@SwipeRefreshAdapter2
        var textView: TextView
        var imageView: ImageView

        init {
            // 主构造函数没有函数体，如果想写一些逻辑可以使用 init {} 结构体
            println("ViewHolder  init { }== ")
            textView = view.findViewById(R.id.fruitName)
            imageView = view.findViewById(R.id.fruitImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.kotlin_12_material_cardview_fruit_item, parent, false)
        val viewHolder = ViewHolder(view)

        viewHolder.imageView.setOnClickListener {
            //添加点击事件
            val position = viewHolder.adapterPosition
            val fruit = fruitList[position]
            val activity = this.context as Activity
            //使用自定义 Toast 提示
            fruit.name.showToast(context)
            startActivity<FruitActivity>(activity) {
                val intent = Intent()
                intent.putExtra(FruitActivity.FRUIT_NAME, fruit.name)
                intent.putExtra(FruitActivity.FRUIT_IMG_ID, fruit.imageId)
                intent
            }
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.textView.text = fruit.name
        Glide.with(context).load(fruit.imageId).into(holder.imageView)

        // 点击 事件 2
        holder.textView.setOnClickListener {
//            Toast.makeText(context,"点击的 是text", Toast.LENGTH_SHORT).show()
            "点击的 是text".showToast(context,Toast.LENGTH_LONG)

            startActivity2<FruitActivity>(context) {
                putExtra(FruitActivity.FRUIT_NAME, fruit.name)
                putExtra(FruitActivity.FRUIT_IMG_ID, fruit.imageId)
            }
        }

    }
}