package me.camdenorrb.kcommons.store.struct

abstract class MappedStore<K, V> : Store<Map<K, V>, K>() {

	override val data = mutableMapOf<K, V>()


	override fun onDisable() {
		data.clear()
	}


	override operator fun contains(key: K): Boolean {
		return key in data
	}

	override fun remove(key: K): Boolean {
		return data.remove(key) != null
	}

	override fun data(): Map<K, V> {
		return data
	}


	open operator fun get(key: K): V? {
		return data[key]
	}


	open fun register(key: K, value: V) {
		data[key] = value
	}

}