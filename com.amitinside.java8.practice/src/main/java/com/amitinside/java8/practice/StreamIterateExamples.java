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

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class StreamIterateExamples {

	private static List<Long> getFirst100PrimeNo() {

		return Stream.iterate(1L, num -> num + 1).limit(100).filter(StreamIterateExamples::isPrime)
				.collect(Collectors.toList());

	}

	private static boolean isPrime(final long num) {
		long temp;
		boolean isPrime = true;
		for (long i = 2; i <= (num / 2); i++) {
			temp = num % i;
			if (temp == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;

	}

	public static void main(final String[] args) {
		System.out.println(getFirst100PrimeNo());
	}

}
