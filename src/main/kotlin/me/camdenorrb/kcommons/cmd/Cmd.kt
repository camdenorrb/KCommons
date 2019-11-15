package me.camdenorrb.kcommons.cmd

interface Cmd<C : CmdContext> {

    fun C.execute()

    fun C.onCantExecute()

    fun C.canExecute(): Boolean

    fun isThis(cmd: String): Boolean


    /**
     * Handles the execution process for you
     *
     * @return If they were able to execute the command
     */
    @JvmDefault
    fun executeWithChecks(context: C): Boolean {

        if (!context.canExecute()) {
            context.onCantExecute()
            return false
        }

        context.execute()
        return true
    }

}