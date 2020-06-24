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
import kotlinx.android.synthetic.main.kotlin_12_drawer_layout_activity.*
import kotlinx.android.synthetic.main.kotlin_12_navigation_view_activity.*
import kotlinx.android.synthetic.main.kotlin_12_navigation_view_activity.DrawerLayout

/**
 * @author zhouchao
 * @date 2020/6/22
 */
class NavigationViewActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_12_navigation_view_activity)

        //1.添加依赖库 material 库
        //2.准备 menu 文件 nav_menu
        //2.1 menu 中嵌套一个group 标签，并且将checkableBehavior 属性设置为 single 表示菜单中是单选
        //   如：<group android:checkableBehavior="single">

        //3. 在 layout 中创建 kotlin_nav_header.xml ,作为NavigationView 的显示布局

        //4 重点来了，在 activity 的布局中 添加 NavigationView
        // 并且将 nav_menu.xml 和 kotlin_nav_header.xml 设置到到NavigationView
        setSupportActionBar(toolbar)

        supportActionBar?.let {
            //Toolbar 最左侧的按钮叫做 Home 默认图标是个返回箭头含义是返回上一个activity ;
            // id 是固定的 android.R.id.home
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        navigationView.setCheckedItem(R.id.navCall)
        navigationView.setNavigationItemSelectedListener {
            DrawerLayout.closeDrawers()//关闭左侧栏，
            true  //事件已经处理
        }

        //在 manifest 中自定义的them Kotlin_no_toolbar 会异常退出，Kotlin_no_toolbar2就没有问题^_^
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