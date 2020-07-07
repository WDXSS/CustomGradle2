package com.example.kotlin._13kotlin.viewModel

import androidx.lifecycle.ViewModel
import com.example.kotlin._2kotlin.DevKotlin

@DevKotlin("ViewModelActivity  的 ViewModel ")
class MainViewModel2(countReserved:Int) :ViewModel(){
    var counter = 0
    init {
        counter = countReserved
    }

}