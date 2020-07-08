package com.example.kotlin._13kotlin.liveData

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin._2kotlin.DevKotlin

@DevKotlin(" ViewModel 中使用LiveData ")
class MainViewModel2(countReserved: Int) : ViewModel() {
    var counterLiveData = MutableLiveData<Int>()

    init {
        //LiveData 读写数据有三种 方式
        // 读： getValue()
        // 写： setValue() 只能用在 主线程中， postValue() 非主线程中
        counterLiveData.value = countReserved
    }


    fun plusOne() {
        val count = counterLiveData.value ?: 0
        counterLiveData.value = count + 1
    }

    fun clear(){
        counterLiveData.value = 0
    }
}