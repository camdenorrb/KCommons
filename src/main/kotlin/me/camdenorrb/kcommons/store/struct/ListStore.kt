package me.camdenorrb.kcommons.store.struct

abstract class ListStore<K> : Store<List<K>, K>() {

	override val data = mutableListOf<K>()


	override fun contains(key: K): Boolean {
		return key in data
	}

	override fun remove(key: K): Boolean {
		return data.remove(key)
	}

	override fun data(): List<K> {
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