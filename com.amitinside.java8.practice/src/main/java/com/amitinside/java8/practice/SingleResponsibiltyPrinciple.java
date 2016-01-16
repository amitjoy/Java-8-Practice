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

import java.util.stream.IntStream;

import org.jooq.lambda.Seq;

public final class SingleResponsibiltyPrinciple {

	public long countPrimes(final int upTo) {
		return IntStream.rangeClosed(1, upTo).parallel().filter(this::isprime).count();
	}

	private boolean isprime(final int num) {
		return IntStream.rangeClosed(2, num).allMatch(element -> (num % element) != 0);
	}

	private boolean isPrime2(final int number) {
		return Seq.range(2, number).allMatch(element -> (number % element) != 0);
	}

}
