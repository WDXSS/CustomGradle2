package com.example.kotlin._13kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin.R
import com.example.kotlin._13kotlin.liveData.MainViewModel
import com.example.kotlin._13kotlin.liveData.MainViewModel2
import com.example.kotlin._13kotlin.liveData.MainViewModelFactory
import com.example.kotlin._2kotlin.DevKotlin
import kotlinx.android.synthetic.main.kotlin_13_live_data_main_activity.*

@DevKotlin("live Data 的基本用法  MainViewModel2 对外提供 liveData 只能 读取数据不能修改数据")
class LiveDataMainActivity2 : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_13_live_data_main_activity)
        // liveData 是 jetpack 提供的一种响应式编程组件，它可以包含任何类型的数据，并在数据发生变化是通知观察者
        // liveData 特别适合和ViewModel 结合在一起使用，虽然它也可以单独使用，

        //LiveData 基本用法
        initViewModel()
        plusBtn.setOnClickListener {
            viewModel.plusOne()
        }
        clearBtn.setOnClickListener {
            viewModel.clear()

        }

        //observe(param1, param2) 两个入参都是 单实现的接口，为啥不能使用 Java 函数API 的写法？
        // P548 解惑
        viewModel.counter.observe(this, Observer { observer ->
            //监听 ViewModel 中  liveData 的数据变化
            text.text = observer.toString()
        })
        //使用 如下语法结构的 方式需要 添加依赖
        //mplementation "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0-alpha05"
//        viewModel2.counterLiveData.observe(this){}
    }

    private fun initViewModel() {
        if (!::viewModel.isInitialized) {
            viewModel = ViewModelProvider(this, MainViewModelFactory(4)).get(MainViewModel2::class.java)
        }
    }




}