package com.example.kotlin._13kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.R
import com.example.kotlin._2kotlin.DevKotlin
import com.example.kotlin.startActivity
import kotlinx.android.synthetic.main.kotlin_13_jetpack_main_activity.*

@DevKotlin("开启 Jetpack 之旅")
class JetpackMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_13_jetpack_main_activity)

        viewModelBtn.setOnClickListener {
           startActivity<ViewModelActivity>(this)
        }

        lifecycleBtn.setOnClickListener {
            startActivity<LifecycleMainActivity>(this)
        }
        liveDataBtn.setOnClickListener {
            startActivity<LiveDataMainActivity>(this)
        }
        liveDataBtn2.setOnClickListener {
            startActivity<LiveDataMainActivity2>(this)
        }
        liveDataBtn3.setOnClickListener {
            startActivity<LiveDataTransformationActivity>(this)
        }
        liveDataBtn4.setOnClickListener {
            startActivity<LiveDataTransformationActivity2>(this)
        }
    }
}