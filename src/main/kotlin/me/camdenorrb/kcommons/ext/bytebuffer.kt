package me.camdenorrb.kcommons.ext

import java.nio.ByteBuffer
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

// TODO: Look into https://github.com/OpenHFT/Chronicle-Bytes for clean output


fun ByteBuffer.getBytes(size: Int): ByteArray {
    return ByteArray(size).apply { get(this) }
}

fun ByteBuffer.decodeToString(encoding: Charset = StandardCharsets.UTF_8): String {
    return encoding.decode(this).toString()
}

fun ByteBuffer.getByteBuffer(size: Int): ByteBuffer {

    val slice = slice(position(), size)
    position(position() + size)

    return slice
}

fun ByteBuffer.getBoolean(): Boolean {
    return when (val read = get().toInt()) {

        0 -> false
        1 -> true

        else -> error("Unable to read boolean '$read'")
    }
}