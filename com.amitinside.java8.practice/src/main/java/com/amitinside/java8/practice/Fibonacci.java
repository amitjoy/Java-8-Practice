/*******************************************************************************
 * Copyright 2016 Amit Kumar Mondal
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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