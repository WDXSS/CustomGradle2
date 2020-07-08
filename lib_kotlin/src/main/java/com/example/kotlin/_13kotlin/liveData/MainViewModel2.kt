package com.example.kotlin._13kotlin.liveData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin._2kotlin.DevKotlin

@DevKotlin("优化：对非 ViewModel类 只提供不可修改的 LiveData ，而不是 可修改的 MutableLiveData ")
class MainViewModel2(countReserved: Int) : ViewModel() {
    //get 的用法
    public val counter: LiveData<Int>
        get() {
            return _counter
        }

    private val _counter = MutableLiveData<Int>()

    init {
        _counter.value = countReserved
    }

    fun plusOne() {
        val count = _counter.value ?: 0
        _counter.value = count + 1
    }

    fun clear() {
        _counter.value = 0
    }
}