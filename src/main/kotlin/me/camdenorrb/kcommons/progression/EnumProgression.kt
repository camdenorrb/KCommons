package me.camdenorrb.kcommons.progression

open class EnumProgression<T : Enum<T>>(val enumClazz: Class<T>, val start: T, val endInclusive: T) : Iterable<T> {

    val values = enumClazz.enumConstants


    override fun iterator(): Iterator<T> {
        return EnumProgressionIterator()
    }


    inner class EnumProgressionIterator : Iterator<T> {

        private var current = start.ordinal

        private val lastIndex = endInclusive.ordinal


        override fun hasNext(): Boolean {
            return current <= lastIndex
        }

        override fun next(): T {
            return values[current++]
        }

    }

}