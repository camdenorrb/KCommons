package me.camdenorrb.kcommons

import me.camdenorrb.kcommons.ext.toString
import kotlin.math.nextTowards


fun main() {

    println(2.0001.toString(digits = 4))
    /*
    for (i in Thing.A..Thing.B) {
        println(i)
    }*/

}

enum class Thing {
    A, B
}