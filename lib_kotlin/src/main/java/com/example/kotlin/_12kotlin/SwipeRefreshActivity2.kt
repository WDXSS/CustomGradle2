package com.example.kotlin._12kotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlin.R
import com.example.kotlin._12kotlin.adapter.SwipeRefreshAdapter2
import com.example.kotlin._12kotlin.enity.Fruit
import com.example.kotlin._2kotlin.DevKotlin
import kotlinx.android.synthetic.main.kotlin_12_swipe_refresh_activity.*
import kotlinx.android.synthetic.main.kotlin_12_swipe_refresh_activity2.*
import kotlin.concurrent.thread

@DevKotlin("练习 下拉刷新")
class SwipeRefreshActivity2 : AppCompatActivity() {

    private val fruits = mutableListOf(Fruit("Apple", R.drawable.apple),
            Fruit("Banana", R.drawable.banana),
            Fruit("Orange", R.drawable.orange),
            Fruit("Watermelon", R.drawable.watermelon),
            Fruit("Pear", R.drawable.pear),
            Fruit("Grape", R.drawable.grape),
            Fruit("Pineapple", R.drawable.pineapple),
            Fruit("Strawberry", R.drawable.strawberry),
            Fruit("Cherry", R.drawable.cherry),
            Fruit("Mango", R.drawable.mango))

    private val fruitList: ArrayList<Fruit> = ArrayList()
    private lateinit var gridLayoutManager: GridLayoutManager
    lateinit var adapter: SwipeRefreshAdapter2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_12_swipe_refresh_activity2)
        setupActionBar()
        setupNavigationView()
        initData()
        initRecycleView()
        setupSwipeRefresh()
    }

    private fun setupSwipeRefresh() {
        //设置 进度条的颜色
        swipeRefresh2.setColorSchemeColors(ContextCompat.getColor(this, R.color.colorPrimary),
                ContextCompat.getColor(this, R.color.KotlinColorPrimary))

        //添加下拉刷新的监听
        swipeRefresh2.setOnRefreshListener {
            refreshData()
        }

    }
    private fun refreshData() {
        thread {
            Thread.sleep(2000)
            runOnUiThread {
                this.fruitList.clear()
                repeat(20) {
                    val index = (0 until fruits.size).random()
                    fruitList.add(fruits[index])
                }
                adapter.notifyDataSetChanged()

                //调用 setRefreshing() 方法 传入 false 停止刷新效果
                swipeRefresh2.isRefreshing = false
            }
        }

    }


    private fun initRecycleView() {
        if (!::gridLayoutManager.isInitialized) {
            gridLayoutManager = GridLayoutManager(this, 2)
        }
        if (!::adapter.isInitialized) {
            adapter = SwipeRefreshAdapter2(this,fruitList)
        }

        recyclerView2.layoutManager = this.gridLayoutManager
        recyclerView2.adapter = this.adapter

    }


    private fun initData() {
        repeat(30) {
            val index = (0 until fruits.size).random()
            fruitList.add(fruits[index])
        }

    }


    private fun setupNavigationView() {
        navigationView2.setCheckedItem(R.id.navTask)
        navigationView2.setNavigationItemSelectedListener {
            drawerLayout2.closeDrawers()//关闭左侧栏，
            when (it.itemId) {
                R.id.navCall -> Toast.makeText(this, "you clicked navCall", Toast.LENGTH_LONG).show()
                R.id.navFriends -> Toast.makeText(this, "you clicked navFriends", Toast.LENGTH_LONG).show()
                R.id.navLocation -> Toast.makeText(this, "you clicked navLocation", Toast.LENGTH_LONG).show()
                R.id.navMail -> Toast.makeText(this, "you clicked navMail", Toast.LENGTH_LONG).show()
                R.id.navTask -> Toast.makeText(this, "you clicked navTask", Toast.LENGTH_LONG).show()
            }
            true
        }
    }


    private fun setupActionBar() {
        setSupportActionBar(toolbar2)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_menu)
        }
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
            android.R.id.home -> drawerLayout2.openDrawer(Gravity.START)
        }
        return true
    }
}