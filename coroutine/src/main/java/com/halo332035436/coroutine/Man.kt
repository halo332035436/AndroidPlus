package com.halo332035436.coroutine

import kotlin.coroutines.suspendCoroutine


class Man(name: String) {

    companion object {
        suspend fun <T> run() {
            suspendCoroutine<T> { }
        }
    }

    val nameLength = name.length
    var age: Int

    init {
        age = 28
    }

    constructor(name: String, nameLength: Int, age: Int) : this(name) {
        Any()
    }

}