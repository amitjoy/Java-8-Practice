package com.amitinside.java8.collection;

import java.util.AbstractMap;
import java.util.Map;

import com.google.common.collect.Maps;

public final class MapUtil {

	public static <K, V> Map.Entry<K, V> entry(final K key, final V value) {
		return new AbstractMap.SimpleEntry<K, V>(key, value);
	}

	public static void main(final String[] args) {
		final Map<String, Integer> map = mapOf(entry("a", 1), entry("b", 2), entry("c", 3));
		System.out.println(map);
	}

	@SafeVarargs
	public static <K, V> Map<K, V> mapOf(final Map.Entry<K, V>... entries) {
		final Map<K, V> map = Maps.newLinkedHashMap();

		for (final Map.Entry<K, V> entry : entries) {
			map.put(entry.getKey(), entry.getValue());
		}
		return map;

	}

	private MapUtil() {
	}

}
