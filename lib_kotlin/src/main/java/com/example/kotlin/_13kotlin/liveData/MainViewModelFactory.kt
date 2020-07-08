package com.example.kotlin._13kotlin.liveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin._2kotlin.DevKotlin

@Suppress("UNCHECKED_CAST")
@DevKotlin("通过 ViewModelProvider.Factory 向 ViewModel 中传值 ")
class MainViewModelFactory(val countReserved: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel2(countReserved) as T
    }
}