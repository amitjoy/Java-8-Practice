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
package com.amitinside.java8.lazy;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Optional;
import java.util.function.Supplier;

public final class Lazy<T> {

	public static <T> Lazy<T> of() {
		return new Lazy<>();
	}

	private volatile T value;

	private Lazy() {
	}

	private synchronized T compute(final Supplier<T> supplier) {
		return Optional.ofNullable(this.value).map(value -> checkNotNull(supplier.get())).get();
	}

	public T get(final Supplier<T> supplier) {
		final T result = this.value;
		return Optional.ofNullable(this.value).map(value -> result).orElse(this.compute(supplier));
	}
}