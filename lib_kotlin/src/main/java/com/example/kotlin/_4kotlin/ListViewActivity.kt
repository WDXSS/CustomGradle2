package com.example.kotlin._4kotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin._2kotlin.DevKotlin
import com.example.kotlin._4kotlin.entity.Fruit
import kotlinx.android.synthetic.main.kotlin_listview_activity.*
@DevKotlin("")
class ListViewActivity : AppCompatActivity() {
    //可变集合 mutableListOf
    var fruitList = mutableListOf<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_listview_activity)
        initFruits()
        val adapter = FruitAdapter(this, R.layout.kotlin_4_adapter_fruit_item, fruitList)
        listView.adapter = adapter

        //Parameter 'parent' is never used, could be renamed to _
        listView.setOnItemClickListener { _, _, position, _ ->
            val fruit = fruitList[position]
            Toast.makeText(this, fruit.name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initFruits() {
        // kotlin 标准函数 repeat
        // repeat 函数将所有的水果数据添加了 两遍
        repeat(2) {
            fruitList.add(Fruit("Apple", R.mipmap.apple_pic))
            fruitList.add(Fruit("Banana", R.mipmap.banana_pic))
            fruitList.add(Fruit("Orange", R.mipmap.orange_pic))
            fruitList.add(Fruit("Watermelon", R.mipmap.watermelon_pic))
            fruitList.add(Fruit("Pear", R.mipmap.pear_pic))
            fruitList.add(Fruit("Grape", R.mipmap.grape_pic))
            fruitList.add(Fruit("Pineapple", R.mipmap.pineapple_pic))
            fruitList.add(Fruit("Strawberry", R.mipmap.strawberry_pic))
            fruitList.add(Fruit("Cherry", R.mipmap.cherry_pic))
            fruitList.add(Fruit("Mango", R.mipmap.mango_pic))
        }
    }


}