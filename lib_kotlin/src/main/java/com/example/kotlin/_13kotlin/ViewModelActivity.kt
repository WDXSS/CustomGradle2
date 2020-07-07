package com.example.kotlin._13kotlin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin.R
import com.example.kotlin._13kotlin.viewModel.MainViewModel
import com.example.kotlin._13kotlin.viewModel.MainViewModel2
import com.example.kotlin._13kotlin.viewModel.MainViewModelFactory
import com.example.kotlin._2kotlin.DevKotlin
import kotlinx.android.synthetic.main.kotlin_13_view_model_activity.*

@DevKotlin("ViewModel 基础用法")
class ViewModelActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var viewModel2: MainViewModel2
    lateinit var sp: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_13_view_model_activity)
        // 前奏
        // 1. ViewModel 是 Activity 专门用于存与UI相关数据，只要是界面上看到的数据 ，
        // 它的相关变量都应该存放在ViewModel中，而不是Activity中
        // 2. ViewModel 的生命周期 和 Activity 不同，可以保证 在手机屏幕发生翻转的时候，viewModel不会被重新创建
        //    只有在 Activity 被销毁时 一起销毁

        //基本用法
        // 编程规范 给每一个 activity 和 Fragment 都创建一个ViewModel 并继承自 ViewModel
        iniViewModel()
        initView()
        refreshCounter()

        //向 ViewModel 中传值
        sp = getPreferences(Context.MODE_PRIVATE)


        iniViewModel2()
        initView2()
        refreshCounter2()

        clear.setOnClickListener {
            viewModel.counter = 0
            viewModel2.counter = 0

            refreshCounter()
            refreshCounter2()
        }
    }

    private fun iniViewModel() {
        //过时了
//        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        //代替方法
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private fun initView() {
        plusBtn.setOnClickListener {
            viewModel.counter++
            refreshCounter()
        }
    }

    private fun refreshCounter() {
        text.text = viewModel.counter.toString()
    }


    private fun iniViewModel2() {
        // 通过 通过 ViewModelProvider.Factory 向 ViewModel 中传值
        val counter = sp.getInt("count_reserved", 0)
        viewModel2 = ViewModelProvider(this, MainViewModelFactory(counter)).get(MainViewModel2::class.java)
    }

    private fun initView2() {
        plusBtn2.setOnClickListener {
            viewModel2.counter++
            refreshCounter2()
        }
    }

    private fun refreshCounter2() {
        text2.text = viewModel2.counter.toString()
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            //保存 viewModel2 中的数值
            putInt("count_reserved",viewModel2.counter)
        }
    }
}