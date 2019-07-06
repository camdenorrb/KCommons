package me.camdenorrb.kcommons

import me.camdenorrb.kcommons.ext.isGenericSubtypeOf
import me.camdenorrb.kcommons.ext.isGenericSupertypeOf
import kotlin.reflect.full.isSubtypeOf
import kotlin.reflect.full.isSupertypeOf
import kotlin.reflect.typeOf
import kotlin.test.Test

@ExperimentalStdlibApi
class ExtTest {

    @Test
    fun genericTypeExtTest() {

        // Basic
        check(typeOf<String>().isGenericSubtypeOf(typeOf<Any>()))
        check(typeOf<Any>().isGenericSupertypeOf(typeOf<String>()))

        // Basic generic test
        check(typeOf<GenericThing<String>>().isGenericSubtypeOf(typeOf<GenericThing<Any>>()))
        check(typeOf<GenericThing<Any>>().isGenericSupertypeOf(typeOf<GenericThing<String>>()))

        // Extreme generic test
        check(typeOf<GenericThing<GenericThing<String>>>().isGenericSubtypeOf(typeOf<GenericThing<GenericThing<Any>>>()))
        check(typeOf<GenericThing<GenericThing<Any>>>().isGenericSupertypeOf(typeOf<GenericThing<GenericThing<String>>>()))


        // Basic negation
        check(!typeOf<Any>().isGenericSubtypeOf(typeOf<String>()))
        check(!typeOf<String>().isGenericSupertypeOf(typeOf<Any>()))

        // Basic negation generic test
        check(!typeOf<GenericThing<Any>>().isGenericSubtypeOf(typeOf<GenericThing<String>>()))
        check(!typeOf<GenericThing<String>>().isGenericSupertypeOf(typeOf<GenericThing<Any>>()))

        // Extreme negation generic test
        check(!typeOf<GenericThing<GenericThing<Any>>>().isGenericSubtypeOf(typeOf<GenericThing<GenericThing<String>>>()))
        check(!typeOf<GenericThing<GenericThing<String>>>().isGenericSupertypeOf(typeOf<GenericThing<GenericThing<Any>>>()))


        // Kotlin tests to see if my efforts are worthless
        check(!typeOf<GenericThing<String>>().isSubtypeOf(typeOf<GenericThing<Any>>()))
        check(!typeOf<GenericThing<Any>>().isSupertypeOf(typeOf<GenericThing<String>>()))

        check(!typeOf<GenericThing<GenericThing<String>>>().isSubtypeOf(typeOf<GenericThing<GenericThing<Any>>>()))
        check(!typeOf<GenericThing<GenericThing<Any>>>().isSupertypeOf(typeOf<GenericThing<GenericThing<String>>>()))
    }


    class GenericThing<T>

}