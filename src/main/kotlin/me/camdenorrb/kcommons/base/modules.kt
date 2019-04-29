package me.camdenorrb.kcommons.base

interface ModuleBase : Named {

	fun enable() = Unit

	fun disable() = Unit

}

abstract class ModuleStruct : ModuleBase {

	@Transient @Volatile
	var isEnabled = false
		private set


	protected open fun onEnable() = Unit

	protected open fun onDisable() = Unit


	final override fun enable() {
		if (!isEnabled) {
			onEnable()
			isEnabled = true
		}
	}

	final override fun disable() {
		if (isEnabled) {
			onDisable()
			isEnabled = false
		}
	}

}