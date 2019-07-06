package me.camdenorrb.kcommons

import me.camdenorrb.kcommons.ext.rangeTo
import kotlin.test.Test

class EnumTest {

    @Test
    fun enumRangeTest() {
        check(Example.ONE.rangeTo(Example.TWO).joinToString() == "ONE, TWO")
        check(Example.ONE.rangeTo(Example.THREE).joinToString() == "ONE, TWO, THREE")
    }


    enum class Example {
        ONE, TWO, THREE
    }

}