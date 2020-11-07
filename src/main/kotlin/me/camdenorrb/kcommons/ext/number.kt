package me.camdenorrb.kcommons.ext

// TODO: Add a way to round to a certain digit
fun Double.toString(digits: Int): String {
    val asString = this.toString()
    return "${asString.substringBefore('.')}.${asString.substringAfter('.').take(digits).padEnd(digits, '0')}"
}