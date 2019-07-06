package me.camdenorrb.kcommons.store.struct

abstract class SetStore<K> : Store<Set<K>, K>() {

	override val data = mutableSetOf<K>()


	override fun contains(key: K): Boolean {
		return key in data
	}

	override fun remove(key: K): Boolean {
		return data.remove(key)
	}

	override fun data(): Set<K> {
		return data
	}

	override fun onDisable() {
		data.clear()
	}


	open fun register(key: K) {
		data.add(key)
	}

	open fun register(vararg keys: K) {
		for (key in keys) {
			register(key)
		}
	}

}