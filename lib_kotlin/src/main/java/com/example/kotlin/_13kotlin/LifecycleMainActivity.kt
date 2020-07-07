package com.example.kotlin._13kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.R
import com.example.kotlin._13kotlin.lifecycle.LifecycleMainObserver
import com.example.kotlin._2kotlin.DevKotlin
import com.example.kotlin._2kotlin.testLambda
import kotlinx.android.synthetic.main.kotlin_13_lifecycle_main_activity.*
import kotlin.concurrent.thread

@DevKotlin("lifecycle 监听 activity 的生命周期")
class LifecycleMainActivity : AppCompatActivity() {

    lateinit var observer: LifecycleMainObserver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_13_lifecycle_main_activity)

        observer = LifecycleMainObserver()
        //监听 Activity 的生命周期 实现 LifecycleObserver 接口
        lifecycle.addObserver(observer)
        lifecycle.currentState //获取 当前生命周期的状态

        test()
    }
    private fun test(){
        thread {
            Thread.sleep(2000)
            runOnUiThread {
                text.text = observer.str
            }
        }
    }
}