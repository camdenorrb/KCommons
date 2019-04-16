package me.camdenorrb.kcommons.cmd

interface Cmd<C : CmdContext> {

    fun execute(context: C)

    fun onCantExecute(context: C)

    fun canExecute(context: C): Boolean

    fun isThis(cmd: String): Boolean


    /**
     * Handles the execution process for you
     *
     * @return If they were able to execute the command
     */
    @JvmDefault
    fun executeWithChecks(context: C): Boolean {

        if (!canExecute(context)) {
            onCantExecute(context)
            return false
        }

        execute(context)
        return true
    }

}