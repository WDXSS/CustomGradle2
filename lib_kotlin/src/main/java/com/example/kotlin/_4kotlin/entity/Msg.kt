package com.example.kotlin._4kotlin.entity

class Msg {
    // lateinit  延迟初始化 的关键字
    var content: String
    var type: Int = -1

    constructor(content: String) : this(content, Msg.TYPE_SENT)
    constructor(content2: String, type2: Int) {
        this.content = content2
        this.type = type2
    }

    companion object {
        //const 定义为 常量的关键字
        const val TYPE_RECEIVED = 0
        const val TYPE_SENT = 1
    }

    fun printlnMsg() {
        val typeStr = if (type == TYPE_RECEIVED) {
            "type_received"
        } else {
            "type_sent"
        }
        println("content = $content , type = $type,   $typeStr")
    }
}