package com.example.kotlin._12kotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlin.R
import com.example.kotlin._12kotlin.adapter.FruitAdapter
import com.example.kotlin._12kotlin.enity.Fruit
import com.example.kotlin._2kotlin.DevKotlin
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.kotlin_12_material_cardview_activity.*
import kotlinx.android.synthetic.main.kotlin_12_material_cardview_activity.floatingActionBtn
import kotlinx.android.synthetic.main.kotlin_12_material_cardview_activity.navigationView
import kotlinx.android.synthetic.main.kotlin_12_material_cardview_activity.toolbar
import kotlinx.android.synthetic.main.kotlin_12_navigation_view_activity2.*

@DevKotlin("MaterialCardView   通过 RecyclerView 添加 MaterialCardView 为根布局的 item")
class MaterialCardViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_12_material_cardview_activity)
        setSupportActionBar(toolbar)

        floatingActionBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                v?.let {
                    Snackbar.make(it, "点我啊", Snackbar.LENGTH_LONG).setAction("点我22") {
                        Toast.makeText(v.context, "《点我22》 干啥？？", Toast.LENGTH_LONG).show()
                    }.show()
                }
            }
        })

        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        navigationView.setCheckedItem(R.id.navFriends)
        navigationView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawers()
            when (it.itemId) {
                R.id.navCall -> Toast.makeText(this, "you clicked navCall", Toast.LENGTH_LONG).show()
                R.id.navFriends -> Toast.makeText(this, "you clicked navFriends", Toast.LENGTH_LONG).show()
                R.id.navLocation -> Toast.makeText(this, "you clicked navLocation", Toast.LENGTH_LONG).show()
                R.id.navMail -> Toast.makeText(this, "you clicked navMail", Toast.LENGTH_LONG).show()
                R.id.navTask -> Toast.makeText(this, "you clicked navTask", Toast.LENGTH_LONG).show()
            }
            true
        }

        initRecyclerView()
    }

    @DevKotlin("添加菜单")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    @SuppressLint("WrongConstant")
    @DevKotlin("菜单的点击 事件")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        println("onOptionsItemSelected")
        when (item.itemId) {
            R.id.backup -> Toast.makeText(this, "you clicked backup", Toast.LENGTH_LONG).show()
            R.id.delete -> Toast.makeText(this, "you click delete", Toast.LENGTH_LONG).show()
            R.id.settings -> Toast.makeText(this, "you click settings", Toast.LENGTH_LONG).show()

            //Toolbar 最左侧的按钮叫做 Home 默认图标是个返回箭头含义是返回上一个activity ;
            // id 是固定的 android.R.id.home
            android.R.id.home -> drawerLayout.openDrawer(Gravity.START)
        }
        return true
    }

    // 设置 RecycleView 显示的内容
    val fruits = mutableListOf(Fruit("Apple", R.drawable.apple),
            Fruit("Banana", R.drawable.banana),
            Fruit("Orange", R.drawable.orange),
            Fruit("Watermelon", R.drawable.watermelon),
            Fruit("Pear", R.drawable.pear),
            Fruit("Grape", R.drawable.grape),
            Fruit("Pineapple", R.drawable.pineapple),
            Fruit("Strawberry", R.drawable.strawberry),
            Fruit("Cherry", R.drawable.cherry),
            Fruit("Mango", R.drawable.mango))

    val fruitList = ArrayList<Fruit>()

    private fun initRecyclerView() {
        //坑 1  使用 MaterialCardView 需要配合是使用对应的 MaterialComponents 主题
//        或者
//        <com.google.android.material.card.MaterialCardView xmlns:android="http://schemas.android.com/apk/res/android"
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content"
//        xmlns:app="http://schemas.android.com/apk/res-auto"
//        android:layout_margin="5dp"
//        app:cardCornerRadius="4dp"
//        android:theme="@style/Theme.MaterialComponents.Light"
//        >
//        加入 android:theme="@style/Theme.MaterialComponents.Light"
        initFruits()
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(this, fruitList)
        recyclerView.adapter = adapter
    }


    private fun initFruits() {
        fruitList.clear()
        repeat(50) {
            val index = (0 until fruits.size).random()
            fruitList.add(fruits[index])
        }
    }
}