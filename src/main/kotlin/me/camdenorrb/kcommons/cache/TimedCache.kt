package me.camdenorrb.kcommons.cache;

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.ConcurrentSkipListMap
import java.util.concurrent.atomic.AtomicBoolean

// Negative poll intervals disable automated polling
class TimedCache<K, V>(val defaultDuration: Long, val pollIntervalMillis: Long = 1_000) {

    private var isPolling = AtomicBoolean(pollIntervalMillis >= 0)

    private val expireListeners = mutableSetOf<(ExpireInfo) -> Unit>()


    // (Key) --> (Expire time)
    private val expireData = ConcurrentSkipListMap<K, Long>()

    private val sortedData = ConcurrentSkipListMap<K, V> { prev, next ->

        val prevVal = expireData[prev] ?: 0L
        val nextVal = expireData[next] ?: 0L

        val result = prevVal.compareTo(nextVal)

        // Fixes issues with ConcurrentSkipListMap on equal comparisons
        if (result == 0) prev.hashCode().compareTo(next.hashCode()) else result
    }


    init {
        if (isPolling.get()) {
            GlobalScope.launch(Dispatchers.Default) {
                while (isPolling.get()) {
                    poll()
                    delay(pollIntervalMillis)
                }
            }
        }
    }


    fun clear() {
        expireData.clear()
        sortedData.clear()
    }

    fun onExpire(block: (ExpireInfo) -> Unit) {
        expireListeners += block
    }


    fun put(key: K, value: V) {
        put(key, value, System.currentTimeMillis() + defaultDuration)
    }

    fun put(key: K, value: V, expireTime: Long) {
        expireData[key] = expireTime
        sortedData[key] = value
    }


    fun getOrPut(key: K, defaultValue: () -> V): V {
        return getOrPut(key, System.currentTimeMillis() + defaultDuration, defaultValue)
    }

    fun getOrPut(key: K, expireTime: Long, defaultValue: () -> V): V {

        val value = sortedData[key]

        if (value == null) {

            val insertValue = defaultValue()

            expireData[key] = expireTime
            sortedData[key] = insertValue

            return insertValue
        }

        return value
    }


    fun poll() {

        val checkTime = System.currentTimeMillis()

        sortedData.forEach {

            val expireTime = checkNotNull(expireData[it.key]) { "Expire time is null?" }

            // Since it's sorted we know nothing else will return false
            if (expireTime >= checkTime) {
                return
            }

            expireData.remove(it.key)
            sortedData.remove(it.key)

            val removalInfo = ExpireInfo(it.key, expireTime, checkTime)
            expireListeners.forEach { it(removalInfo) }
        }
    }


    inner class ExpireInfo(val key: K, val expireTime: Long, val removalTime: Long)

}