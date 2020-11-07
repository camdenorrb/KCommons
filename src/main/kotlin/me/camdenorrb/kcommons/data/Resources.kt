package me.camdenorrb.kcommons.data

import java.net.URL

object Resources {

    operator fun get(path: String): URL {
        return this::class.java.getResource(path)
    }

}