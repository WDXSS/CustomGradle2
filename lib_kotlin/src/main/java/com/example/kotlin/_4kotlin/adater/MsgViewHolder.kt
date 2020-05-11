package com.example.kotlin._4kotlin.adater

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.R
import com.example.kotlin._2kotlin.DevKotlin

@DevKotlin("密封类 关键字 sealed class ")
sealed class MsgViewHolder(view: View) : RecyclerView.ViewHolder(view)

class LeftViewHolder(view: View) : MsgViewHolder(view) {
    val leftMsg: TextView = view.findViewById(R.id.leftMsg)
}

class RightViewHolder(view: View) : MsgViewHolder(view) {
    val rightMsg: TextView = view.findViewById(R.id.rightMsg)


}

fun sealedTest(holder: MsgViewHolder) {
//    密封类 关键字 sealed class
// 使用密封类 可以不写 else 是因为在 when 语句中传入一个 密封类变量作为条件时，Kotlin 编译器会自动检查该密封类有哪些子类，
// 并强制要求将每个子类所对应的条件全部处理。

// 注意：密封类及其所有子类只能定义在同一个文件的顶层位置，不能嵌套在其他类中，这是被密封类底层的实现机制所限制的
    val test = when (holder) {
        is LeftViewHolder -> "LeftViewHolder"
        is RightViewHolder -> "RightViewHolder"
    }
}

interface Result {}
class Success(val msg: String) : Result {

}

class Failure(val error: String) : Result {

}

fun getResultMsg(result: Result)  {
    //当需要 返回值 时 必须 有个else
    // 对比 方法sealedTest() 密封类 不需要 else
    val resText =  when (result) {
        is Success -> { result.msg }
        is Failure -> { result.error }
        else -> { "" }
    }
}


