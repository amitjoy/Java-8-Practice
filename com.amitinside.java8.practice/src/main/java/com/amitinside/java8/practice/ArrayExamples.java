/*******************************************************************************
 * Copyright 2015, 2016 Amit Kumar Mondal
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

import java.util.Arrays;
import java.util.stream.IntStream;

public final class ArrayExamples {

	public static double[] imperativeInitilize(final int size) {
		final double[] values = new double[size];
		for (int i = 0; i < values.length; i++) {
			values[i] = i;
		}
		return values;
	}

	public static double[] parallelInitialize(final int size) {
		final double[] values = new double[size];
		Arrays.parallelSetAll(values, i -> i);
		return values;
	}

	public static double[] simpleMovingAverage(final double[] values, final int n) {
		final double[] sums = Arrays.copyOf(values, values.length); // <1>
		Arrays.parallelPrefix(sums, Double::sum); // <2>
		final int start = n - 1;
		return IntStream.range(start, sums.length) // <3>
				.mapToDouble(i -> {
					final double prefix = i == start ? 0 : sums[i - n];
					return (sums[i] - prefix) / n; // <4>
				}).toArray(); // <5>
	}

}
