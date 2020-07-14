package com.example.kotlin._13kotlin.liveData

import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.kotlin.util.KotlinStringUtil

class SwitchMapViewModel : ViewModel() {
    private val names = mutableListOf("廉颇", "蔺相如", "越王勾践", "周武列王")
    private var hasName = false
    private val mutableLiveData = MutableLiveData<UserKotlin_13Data>()
    private val mutableLiveDataStr = MutableLiveData<String>()


    val liveData: LiveData<UserKotlin_13Data> = Transformations.switchMap(mutableLiveData) { userName ->
        //每次得到都是一个新的 LiveData 对象
        KotlinStringUtil.printlnAndTime("调用 Transformations.switchMap")
        KotlinStringUtil.printlnAndTime("调用 Transformations.switchMap userName = {$userName}")
        KotlinStringUtil.printlnAndTime("调用 Transformations.switchMap hasName = $hasName")
        if (hasName) {
            hasName = false
            getUserByName(userName.firstName)
        } else {
            getUser()
        }
    }

    val liveDataStr: LiveData<UserKotlin_13Data> = Transformations.switchMap(mutableLiveDataStr) { userName ->
        //每次得到都是一个新的 LiveData 对象

        KotlinStringUtil.printlnAndTime("liveDataStr 调用 Transformations.switchMap")
        KotlinStringUtil.printlnAndTime("liveDataStr 调用 Transformations.switchMap userName = {$userName}")
        KotlinStringUtil.printlnAndTime("liveDataStr 调用 Transformations.switchMap hasName = $hasName")
        getUserByName(userName)

    }

    private fun getUser(): LiveData<UserKotlin_13Data> {
        val index = (0 until names.size).random()
        return Repository.getUserDao(names[index])
    }

    private fun getUserByName(name: String): LiveData<UserKotlin_13Data> {
        return Repository.getUserDao(name)
    }

    fun refreshByName(name: String) {
        hasName = true
        val user = UserKotlin_13Data(name, 1)
        mutableLiveData.value = user
        KotlinStringUtil.printlnAndTime("调用 refreshByName")

        //这里设置mutableLiveDataStr 的泛型 是 String
        //mutableLiveDataStr.value = name 重新赋值,触发监听
        mutableLiveDataStr.value = name
    }

    fun refresh() {
        //更新
        mutableLiveData.value = mutableLiveData.value
    }

}