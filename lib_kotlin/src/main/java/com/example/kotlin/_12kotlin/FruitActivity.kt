package com.example.kotlin._12kotlin

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kotlin.R
import com.example.kotlin._12kotlin.kotlin.*
import com.example.kotlin._2kotlin.DevKotlin
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.kotlin_12_fruit_activity.*

@DevKotlin("可折叠标题栏")
class FruitActivity : AppCompatActivity() {

    companion object {
        //定义静态方法，静态属性
        const val FRUIT_NAME = "fruit_name"
        const val FRUIT_IMG_ID = "fruit_img_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.kotlin_12_fruit_activity)

//        可折叠的标题栏需要借助 CollapsingToolbarLayout .
//        1.CollapsingToolbarLayout 是一个作用于 Toolbar基础之上的布局，
//        2.不能独立存在，只能作为 AppBarLayout 的直接子布局使用

        val name = intent.getStringExtra(FRUIT_NAME) ?: ""
        val imgId = intent.getIntExtra(FRUIT_IMG_ID, 0)

        setSupportActionBar(toolbar) //这里还是设置的 toolbar 哦
//        supportActionBar.setDefaultDisplayHomeAsUpEnabled(true)//这个是不对的， 不要写错啊
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        CollapsingToolbarLayout.title = name
        Glide.with(this).load(imgId).into(fruitImage)

        FruitContextText.text = generateFruitContent(name)
        floatingActionBtn.setOnClickListener {
//            showSnackBar1()//默认写法
//            showSnackBar2()// 没有setAction 的写法
            showSnackBar3()// 实现 setAction 的写法
        }
    }

    private fun showSnackBar1() {
        Snackbar.make(appBarLayout, "floatingActionBar", Snackbar.LENGTH_SHORT)
                .setAction("点我看看") {
                    "Snackbar 的 setAction 点击事件".showToast(this@FruitActivity)
                }.show()
    }

    private fun showSnackBar2() {
        appBarLayout.showSnackBar("view 扩展方法 显示 Snackbar")
    }

    private fun showSnackBar3() {
        appBarLayout.showSnackBar2("view 扩展方法 显示 Snackbar2", "点我看看") {
            "我是通过高价函数实现的点击".showToast(this@FruitActivity)
        }
    }
    private fun showSnackBar4() {
        appBarLayout.showSnackBar3("view 扩展方法 显示 Snackbar2")
    }


    private fun generateFruitContent(fruitName: String) = fruitName.repeat(500)

    @DevKotlin("菜单的点击 事件")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            //Toolbar 最左侧的按钮叫做 Home 默认图标是个返回箭头含义是返回上一个activity ;
            // id 是固定的 android.R.id.home
            android.R.id.home -> finish()
        }
        return true
    }
}