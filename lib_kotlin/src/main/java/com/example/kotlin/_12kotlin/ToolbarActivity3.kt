package com.example.kotlin._12kotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin._2kotlin.DevKotlin
import kotlinx.android.synthetic.main.kotlin_12_material_cardview_activity.*
import kotlinx.android.synthetic.main.kotlin_12_toolbar_activity_v3.navigationView
import kotlinx.android.synthetic.main.kotlin_12_toolbar_activity_v3.toolbar

@DevKotlin("Toolbar  和 RecyclerView 连动")
class ToolbarActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_12_toolbar_activity_v3)
        setupMenuItemClick()
        setupToolbarHome()
        setupNavigationView()
    }


    private fun setupToolbarHome(){
        //setSupportActionBar之后 如果想要显示 menu 需要重写 onCreateOptionsMenu()
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            //Toolbar 最左侧的按钮叫做 Home 默认图标是个返回箭头含义是返回上一个activity ;
            // id 是固定的 android.R.id.home
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_menu)

            supportActionBar?.title = "Toolbar  和 RecyclerView 连动"
        }
    }

    private fun setupNavigationView(){
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