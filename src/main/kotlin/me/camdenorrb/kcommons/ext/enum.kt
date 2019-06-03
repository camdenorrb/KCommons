package me.camdenorrb.kcommons.ext

import me.camdenorrb.kcommons.progression.EnumProgression


inline operator fun <reified T : Enum<T>> T.rangeTo(endInclusive: T): EnumProgression<T> {
    return EnumProgression(T::class.java, this, endInclusive)
}