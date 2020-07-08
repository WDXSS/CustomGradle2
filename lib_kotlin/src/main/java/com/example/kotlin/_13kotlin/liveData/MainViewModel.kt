package com.example.kotlin._13kotlin.liveData

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin._2kotlin.DevKotlin

@DevKotlin(" ViewModel 中使用LiveData ")
class MainViewModel(countReserved: Int) : ViewModel() {
    //推荐写法是：对外只暴露 不可变的 LiveData,这样在非 ViewModel 只能获取数据，不能修改数据
    // 优化 MainViewModel2
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