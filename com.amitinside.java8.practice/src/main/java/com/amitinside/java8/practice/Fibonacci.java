package com.amitinside.java8.practice;

import java.util.Map;

import com.google.common.collect.Maps;

public class Fibonacci {

	private final Map<Integer, Long> cache;

	public Fibonacci() {
		this.cache = Maps.newHashMap();
		this.cache.put(0, 0L);
		this.cache.put(1, 1L);
	}

	public long fibonacci(final int x) {
		return this.cache.computeIfAbsent(x, n -> this.fibonacci(n - 1) + this.fibonacci(n - 2));
	}

}