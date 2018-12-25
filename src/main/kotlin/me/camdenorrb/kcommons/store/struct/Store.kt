package me.camdenorrb.kcommons.store.struct

import me.camdenorrb.kcommons.types.ModuleStruct

abstract class Store<C, K> : ModuleStruct() {

	protected abstract val data: C


	// For public domain usage, should be immutable
	abstract fun data(): C

	abstract fun remove(key: K): Boolean


	abstract operator fun contains(key: K): Boolean

}