package me.camdenorrb.kcommons.ext

import kotlin.reflect.KType
import kotlin.reflect.full.isSubclassOf
import kotlin.reflect.full.isSuperclassOf
import kotlin.reflect.full.withNullability
import kotlin.reflect.jvm.jvmErasure


fun KType.isGenericSubtypeOf(type: KType): Boolean {

    if (!this.jvmErasure.isSubclassOf(type.jvmErasure)) return false

    return arguments.zip(type.arguments).all { (first, second) ->

        val firstType = first.type?.withNullability(false) ?: return@all false
        val secondType = second.type?.withNullability(false) ?: return@all false

        firstType.isGenericSubtypeOf(secondType)
    }
}

fun KType.isGenericSupertypeOf(type: KType): Boolean {

    if (!this.jvmErasure.isSuperclassOf(type.jvmErasure)) return false

    return arguments.zip(type.arguments).all { (first, second) ->

        val firstType = first.type?.withNullability(false) ?: return@all false
        val secondType = second.type?.withNullability(false) ?: return@all false

        firstType.isGenericSupertypeOf(secondType)
    }
}