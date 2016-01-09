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

import java.util.List;
import java.util.stream.IntStream;

public final class Exercise6 {

	public static int multiplyThrough(final List<Integer> numbers) {
		return numbers.parallelStream().mapToInt(num -> num * 5).reduce(1, (num1, num2) -> num1 * num2);
	}

	public static int sequentialSumOfSquares(final IntStream range) {
		return range.map(x -> x * x).sum();
	}

	public static int slowSumOfSquares(final List<Integer> listNumbers) {
		return listNumbers.parallelStream().mapToInt(num -> num * num).sum();
	}

	public static int sumOfSquares(final IntStream range) {
		return range.parallel().map(x -> x * x).sum();
	}

}
