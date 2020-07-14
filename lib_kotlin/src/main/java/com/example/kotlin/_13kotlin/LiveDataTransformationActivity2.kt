package com.example.kotlin._13kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.kotlin.R
import com.example.kotlin._13kotlin.liveData.SwitchMapViewModel
import com.example.kotlin._13kotlin.liveData.TransformationViewModel
import com.example.kotlin._2kotlin.DevKotlin
import com.example.kotlin.util.KotlinStringUtil
import kotlinx.android.synthetic.main.kotlin_13_livedata_transformation_activity.*
import kotlinx.android.synthetic.main.kotlin_13_livedata_transformation_activity.updateNameBtn
import kotlinx.android.synthetic.main.kotlin_13_livedata_transformation_activity.updateUserBtn
import kotlinx.android.synthetic.main.kotlin_13_livedata_transformation_activity.userText
import kotlinx.android.synthetic.main.kotlin_13_livedata_transformation_activity2.*

@DevKotlin("liveData 中 map 和 switchMap 的用法")
class LiveDataTransformationActivity2 : AppCompatActivity() {
    val viewModel = SwitchMapViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_13_livedata_transformation_activity2)

        // switchMap 场景 : 当每次取到的 LiveData 对象都是一个新的对象时，Observer 观察不到新的 LiveData 对象
        updateUserBtn.setOnClickListener {
            viewModel.refresh()
        }
        viewModel.liveData.observe(this, Observer {
            KotlinStringUtil.printlnAndTime("observe  ${it.toString()}")
            userText.text = it.toString()
            //结论：只要 liveData的值被重新赋值了 就会被调用
        })

        updateNameBtn.setOnClickListener {
            val userId = (0..10000).random().toString()
            viewModel.refreshByName(userId)
            //结论 ：liveData 中的数据变化了，但是没有调用 setValue() 或者 postValue() 所以不能触发 observe 的监听
        }


        viewModel.liveDataStr.observe(this, Observer {
            KotlinStringUtil.printlnAndTime("liveDataStr Observer  ${it.toString()}")
            textStr.text = it.toString()
        })


    }
}