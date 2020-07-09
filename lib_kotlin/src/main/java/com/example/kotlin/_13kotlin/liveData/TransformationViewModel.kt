package com.example.kotlin._13kotlin.liveData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.kotlin.util.KotlinStringUtil

/**
 * @author zhouchao
 * @date 2020/7/9
 */
class TransformationViewModel : ViewModel() {
    private val names = mutableListOf("廉颇", "蔺相如", "越王勾践", "周武列王")
    private val userLiveData = MutableLiveData<UserKotlin_13Data>()

    //同过map 转成需要的 liveData
    val userName: LiveData<String> = Transformations.map(userLiveData) { liveData ->
        "${liveData.firstName}"
    }

    fun updateUser() {
        val index = (0 until names.size).random()
        val user = UserKotlin_13Data(names[index], 1)
        userLiveData.value = user
    }
    fun updateUserName() {
        var user = userLiveData.value
        user?.firstName = user?.firstName +" updateName"

        KotlinStringUtil.printlnAndTime("ser?.firstName  = ${user?.firstName }")
        KotlinStringUtil.printlnAndTime("userLiveData?.firstName  = ${userLiveData.value?.firstName }")
        //liveData 中的数据变化了，但是没有调用 setValue() 或者 postValue() 所以不能触发 observe 的监听
//        userLiveData.postValue(user) 调用 set 或者 post 才能触发 监听
    }


}