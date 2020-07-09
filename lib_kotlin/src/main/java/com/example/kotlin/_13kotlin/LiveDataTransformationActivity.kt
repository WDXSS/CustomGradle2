package com.example.kotlin._13kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.kotlin.R
import com.example.kotlin._13kotlin.liveData.TransformationViewModel
import com.example.kotlin._2kotlin.DevKotlin
import com.example.kotlin.util.KotlinStringUtil
import kotlinx.android.synthetic.main.kontlin_13_livedata_transformation_activity.*

@DevKotlin("liveData 中 map 和 switchMap 的用法")
class LiveDataTransformationActivity : AppCompatActivity() {
    val viewModel = TransformationViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kontlin_13_livedata_transformation_activity)

        //map 的用法 当对象 有多条属性，但是只需要监听其中一条属性的变化

        updateUserBtn.setOnClickListener {
            viewModel.updateUser()
        }

        viewModel.userName.observe(this, Observer {
            KotlinStringUtil.printlnAndTime("observe  ${it.toString()}")
            userText.text = it.toString()

            //结论：只要 liveData的值被重新赋值了 就会被调用
        })

        updateNameBtn.setOnClickListener {
            viewModel.updateUserName()
            //结论 ：liveData 中的数据变化了，但是没有调用 setValue() 或者 postValue() 所以不能触发 observe 的监听
        }
    }
}