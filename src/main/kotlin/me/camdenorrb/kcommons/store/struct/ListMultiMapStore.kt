package me.camdenorrb.kcommons.store.struct

import com.google.common.collect.ArrayListMultimap
import com.google.common.collect.ImmutableListMultimap
import com.google.common.collect.ListMultimap

abstract class ListMultiMapStore<K, V> : Store<ListMultimap<K, V>, K>() {

	override val data = ArrayListMultimap.create<K, V>()


	override fun data(): ImmutableListMultimap<K, V> {
		return ImmutableListMultimap.copyOf(data)
	}

	override fun remove(key: K): Boolean {
		return data.removeAll(key).isNotEmpty()
	}

	override fun contains(key: K): Boolean {
		return data.containsKey(key)
	}

	fun hasValue(value: V): Boolean {
		return data.containsValue(value)
	}

	fun hasEntry(key: K, value: V): Boolean {
		return data.containsEntry(key, value)
	}

	open operator fun get(key: K): List<V>? {
		if (!contains(key)) return null
		return data[key]?.takeIf { it.isNotEmpty() }
	}

	open fun register(key: K, value: V) {
		data.put(key, value)
	}

}