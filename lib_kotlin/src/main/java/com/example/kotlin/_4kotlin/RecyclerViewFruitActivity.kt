package com.example.kotlin._4kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.kotlin.R
import com.example.kotlin._2kotlin.DevKotlin
import com.example.kotlin._4kotlin.adater.RecyclerViewFruitAdapter
import com.example.kotlin._4kotlin.entity.FruitEntity
import java.util.*
import kotlin.collections.ArrayList

@DevKotlin("RecyclerView 实例")
class RecyclerViewFruitActivity : AppCompatActivity() {

    private var mRecyclerView: RecyclerView? = null
    private val fruitList = ArrayList<FruitEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_4_recyclerview_fruit_activity)

        mRecyclerView = findViewById(R.id.KotlinRecyclerView4)

        initFruits()
//        //列表
//        val linearLayoutManager = LinearLayoutManager(this)
//        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL  //列表 水平显示 默认是垂直
//        this.mRecyclerView?.layoutManager = linearLayoutManager
        //瀑布流
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        this.mRecyclerView?.layoutManager = layoutManager

        val adapter = RecyclerViewFruitAdapter(fruitList)
        this.mRecyclerView?.adapter = adapter
    }

    private fun initFruits() {
        repeat(2) {
            fruitList.add(FruitEntity(getRandomLengthName("Apple"), R.mipmap.apple_pic))
            fruitList.add(FruitEntity(getRandomLengthName("Banana"), R.mipmap.banana_pic))
            fruitList.add(FruitEntity(getRandomLengthName("Orange"), R.mipmap.orange_pic))
            fruitList.add(FruitEntity(getRandomLengthName("Watermelon"), R.mipmap.watermelon_pic))
            fruitList.add(FruitEntity(getRandomLengthName("Pear"), R.mipmap.pear_pic))
            fruitList.add(FruitEntity(getRandomLengthName("Grape"), R.mipmap.grape_pic))
            fruitList.add(FruitEntity(getRandomLengthName("Pineapple"), R.mipmap.pineapple_pic))
            fruitList.add(FruitEntity(getRandomLengthName("Strawberry"), R.mipmap.strawberry_pic))
            fruitList.add(FruitEntity(getRandomLengthName("Cherry"), R.mipmap.cherry_pic))
            fruitList.add(FruitEntity(getRandomLengthName("Mango"), R.mipmap.mango_pic))
        }
    }
    private fun getRandomLengthName(name: String): String {
        val length = Random().nextInt(20) + 1
        val builder = StringBuilder()
        for (i in 0 until length) {
            builder.append(name)
        }
        return builder.toString()
    }
}