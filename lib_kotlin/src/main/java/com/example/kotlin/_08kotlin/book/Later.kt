package com.example.kotlin._08kotlin.book

import kotlin.reflect.KProperty

class Later<T>(val block: () -> T) {

    var value: Any? = null

    operator fun getValue(any: Any?, prop: KProperty<*>): T {
        if (value == null) {
            value = block()
        }
        return value as T
    }

}

fun <T> later(block: () -> T) = Later(block)