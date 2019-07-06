package me.camdenorrb.kcommons.range

import me.camdenorrb.kcommons.progression.EnumProgression

class EnumRange<T : Enum<T>>(enumClazz: Class<T>, start: T, endInclusive: T) : EnumProgression<T>(enumClazz, start, endInclusive), ClosedRange<T> {

    override fun toString(): String = "$start..$endInclusive"

}