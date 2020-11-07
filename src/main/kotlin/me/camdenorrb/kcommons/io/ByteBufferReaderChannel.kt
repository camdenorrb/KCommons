package me.camdenorrb.kcommons.io

import me.camdenorrb.kcommons.ext.decodeToString
import java.nio.ByteBuffer
import java.nio.charset.Charset

interface ByteBufferReaderChannel {

    // Should inline in implementation
    suspend fun <T> suspendRead(size: Int, block: ByteBuffer.() -> T): T


    suspend fun suspendReadByte(): Byte {
        return suspendRead(Byte.SIZE_BYTES) { get() }
    }

    suspend fun suspendReadBytes(amount: Int): ByteArray {
        return ByteArray(amount) { suspendReadByte() }
    }

    suspend fun suspendReadBoolean(): Boolean {
        return when (val read = suspendReadByte().toInt()) {

            0 -> false
            1 -> true

            else -> error("Unable to read boolean '$read'")
        }
    }

    suspend fun suspendReadShort(): Short {
        return suspendRead(Short.SIZE_BYTES) { short }
    }

    suspend fun suspendReadInt(): Int {
        return suspendRead(Int.SIZE_BYTES) { int }
    }

    suspend fun suspendReadLong(): Long {
        return suspendRead(Long.SIZE_BYTES) { long }
    }

    suspend fun suspendReadFloat(): Float {
        return suspendRead(Float.SIZE_BYTES) { float }
    }

    suspend fun suspendReadDouble(): Double {
        return suspendRead(Double.SIZE_BYTES) { double }
    }

    suspend fun suspendReadString(encoding: Charset = Charsets.UTF_8): String {

        val size = suspendReadShort().toInt()

        return suspendRead(size) {
            this.decodeToString(encoding)
        }
    }

}