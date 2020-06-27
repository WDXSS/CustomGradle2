package com.example.kotlin._12kotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlin.R
import com.example.kotlin._12kotlin.adapter.FruitAdapter
import com.example.kotlin._12kotlin.enity.Fruit
import com.example.kotlin._2kotlin.DevKotlin
import kotlinx.android.synthetic.main.kotlin_12_material_cardview_activity2.*

@DevKotlin("Toolbar  和 RecyclerView 连动")
class MaterialCardViewActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_12_material_cardview_activity2)
//
//        Toolbar 和 RecyclerView 连动
//                解决遮挡问题
//        1.1 Toolbar 设置到AppBarLayout 中
//                1.2. 在 RecyclerView   填 @string/appbar_scrolling_view_behavior 解决遮挡问题
//        2.解决连动问题
//        在 Toolbar 中添加 app:layout_scrollFlags="scroll|enterAlways|snap"
//        scroll：表示当RecyclerView 向上滚动时，Toolbar也会一起向上滚动，实现隐藏
//        enterAlways：表示当 RecycleView 向下滚动时，Toolbar也会向下滚动，实现显示
//        snap：表示当Toolbar还没有完全隐藏或者显示时，会根据当前滚动的距离，自动选择是隐藏还是显示


        setSupportActionBar(toolbar)
        setupNavigationView()
        setupToolbarHome()
        setupMenuItemClick()

        initData()
        initRecycleView()
    }

    val fruitList = ArrayList<Fruit>()
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


    private fun initData() {
        fruitList.clear()
        repeat(20) {
            val index = (0 until fruits.size).random()
            fruitList.add(fruits[index])
        }
    }


    private fun initRecycleView() {
        val adapter: FruitAdapter = FruitAdapter(this, fruitList)

        val gridLayoutManager: GridLayoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = adapter
    }

    private fun setupNavigationView() {
        navigationView.setCheckedItem(R.id.navTask)
        navigationView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawers()//关闭左侧栏，
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

    private fun setupToolbarHome() {
        //setSupportActionBar之后 如果想要显示 menu 需要重写 onCreateOptionsMenu()
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            //Toolbar 最左侧的按钮叫做 Home 默认图标是个返回箭头含义是返回上一个activity ;
            // id 是固定的 android.R.id.home
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_menu)

            supportActionBar?.title = "Toolbar,RecyclerView 连动"
        }
    }

    @SuppressLint("WrongConstant")
    private fun setupMenuItemClick() {
        //在 Toolbar 中添加 app:menu 属性
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.backup -> Toast.makeText(this, "you clicked backup", Toast.LENGTH_LONG).show()
                R.id.delete -> Toast.makeText(this, "you click delete", Toast.LENGTH_LONG).show()
                R.id.settings -> Toast.makeText(this, "you click settings", Toast.LENGTH_LONG).show()

                //Toolbar 最左侧的按钮叫做 Home 默认图标是个返回箭头含义是返回上一个activity ;
                // id 是固定的 android.R.id.home
                android.R.id.home -> drawerLayout.openDrawer(Gravity.START)
            }
            true
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
            android.R.id.home -> drawerLayout.openDrawer(Gravity.START)
        }
        return true
    }
}