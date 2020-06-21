package com.example.kotlin._12kotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.kotlin.R
import com.example.kotlin._2kotlin.DevKotlin
import kotlinx.android.synthetic.main.kotilin_12_drawer_layout_activity.*

@DevKotlin("滑动菜单")
class DrawerLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotilin_12_drawer_layout_activity)
        //DrawerLayout 使用：DrawerLayout布局中允许 放入两个直接子控件
        //1. 第一个子控件是主屏幕要显示的内容
        //2. 第二个子控件是滑动菜单显示的内容

        setSupportActionBar(DrawerLayoutToolbar)

        supportActionBar?.let {
            //Toolbar 最左侧的按钮叫做 Home 默认图标是个返回箭头含义是返回上一个activity ;
            // id 是固定的 android.R.id.home
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
            android.R.id.home -> DrawerLayout.openDrawer(Gravity.START)
        }
        return true
    }
}