/*******************************************************************************
 * Copyright 2015 Amit Kumar Mondal
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

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public final class StringCollector implements Collector<String, StringCombiner, String> {
	private static final Set<Characteristics> characteristics = Collections.emptySet();

	private final String delim;
	private final String prefix;
	private final String suffix;

	public StringCollector(final String delim, final String prefix, final String suffix) {
		this.delim = delim;
		this.prefix = prefix;
		this.suffix = suffix;
	}

	@Override
	// BEGIN accumulator
	public BiConsumer<StringCombiner, String> accumulator() {
		return StringCombiner::add;
	}
	// END accumulator

	@Override
	public Set<Characteristics> characteristics() {
		return characteristics;
	}

	@Override
	// BEGIN combiner
	public BinaryOperator<StringCombiner> combiner() {
		return StringCombiner::merge;
	}
	// END combiner

	@Override
	// BEGIN finisher
	public Function<StringCombiner, String> finisher() {
		return StringCombiner::toString;
	}
	// END finisher

	@Override
	// BEGIN supplier
	public Supplier<StringCombiner> supplier() {
		return () -> new StringCombiner(this.delim, this.prefix, this.suffix);
	}
	// END supplier

}
