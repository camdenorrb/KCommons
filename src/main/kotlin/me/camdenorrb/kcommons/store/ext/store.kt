package me.camdenorrb.kcommons.store.ext

import me.camdenorrb.kcommons.store.struct.ListStore
import me.camdenorrb.kcommons.base.Named

fun <T : Named> ListStore<T>.findByName(name: String, ignoreCase: Boolean = true): T? {
    return data().find { it.name.equals(name, ignoreCase) }
}
