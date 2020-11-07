package me.camdenorrb.kcommons.utils

import kotlin.math.abs


// Distance

fun dist(num1: Float, num2: Float): Float {
    return abs(num1 - num2)
}

fun dist(num1: Double, num2: Double): Double {
    return abs(num1 - num2)
}

fun dist(num1: Int, num2: Int): Int {
    return abs(num1 - num2)
}

fun dist(num1: Long, num2: Long): Long {
    return abs(num1 - num2)
}