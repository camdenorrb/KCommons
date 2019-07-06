package me.camdenorrb.kcommons.file

import java.io.File

sealed class FileFilter : java.io.FileFilter {

    object DIR : FileFilter() {

        override fun accept(file: File): Boolean {
            return file.isDirectory
        }

    }

    object JAR : FileFilter() {

        override fun accept(file: File): Boolean {
            return file.extension.equals("jar", true)
        }

    }

    object YAML : FileFilter() {

        override fun accept(file: File): Boolean {
            val ext = file.extension.toLowerCase()
            return ext == "yml" || ext == "yaml"
        }

    }

    object JSON : FileFilter() {

        override fun accept(file: File): Boolean {
            return file.extension.equals("json", true)
        }

    }

    object Korm : FileFilter() {

        override fun accept(file: File): Boolean {
            return file.extension.equals("korm", true)
        }

    }


    companion object {

        val filters = listOf(DIR, JAR, YAML, JSON)

    }

}