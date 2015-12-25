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

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public final class DiceRolls {

	private static final int N = 100000000;

	private static IntFunction<Integer> twoDiceThrows() {
		return i -> {
			final ThreadLocalRandom random = ThreadLocalRandom.current();
			final int firstThrow = random.nextInt(1, 7);
			final int secondThrow = random.nextInt(1, 7);
			return firstThrow + secondThrow;
		};
	}

	public Map<Integer, Double> parallelDiceRolls() {
		final double fraction = 1.0 / N;
		return IntStream.range(0, N) // <1>
				.parallel() // <2>
				.mapToObj(twoDiceThrows()) // <3>
				.collect(groupingBy(side -> side, // <4>
						summingDouble(n -> fraction))); // <5>
	}

	public Map<Integer, Double> serialDiceRolls() {
		final double fraction = 1.0 / N;
		return IntStream.range(0, N).mapToObj(twoDiceThrows())
				.collect(groupingBy(side -> side, summingDouble(n -> fraction)));
	}

}
