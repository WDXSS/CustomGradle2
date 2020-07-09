package com.example.kotlin._13kotlin.liveData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlin._2kotlin.DevKotlin


/**
 * @author zhouchao
 * @date 2020/7/9
 */

@DevKotlin ("模拟 从 数据库中查询数据")
object Repository {

    fun getUserDao(userName:String) :LiveData<UserKotlin_13Data>{
        val liveData = MutableLiveData<UserKotlin_13Data>()
        val user = UserKotlin_13Data(userName,1)
        liveData.value = user
        return  liveData
    }
}