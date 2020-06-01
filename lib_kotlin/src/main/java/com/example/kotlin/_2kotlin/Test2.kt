package com.example.kotlin._2kotlin

class boy(id: Int) : peosen(id) {

    constructor(id: Int, name: String) : this(id) {

    }

}

open class peosen(id: Int, name: String) {

    constructor(id: Int) : this(id, "") {
        print("constructor")
    }
}

