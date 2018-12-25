package me.camdenorrb.kcommons.cmd

interface Cmd<C : CmdContext> {

    fun C.execute()

    fun C.onCantExecute()

    fun C.canExecute(): Boolean

    fun isThis(cmd: String): Boolean

}