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

import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

import org.jooq.lambda.Seq;

public final class ReduceExample {

	public static void main(final String[] args) {
		final int count = IntStream.rangeClosed(1, 100).reduce(0, (accumulator, element) -> accumulator + element);
		System.out.println(count);

		final int count4 = Seq.rangeClosed(1, 100).reduce(0, (accumulator, element) -> accumulator + element);
		System.out.println(count4);

		final int count2 = IntStream.rangeClosed(0, 100).sum();
		System.out.println(count2);

		final BinaryOperator<Integer> accumulator = (acc, elem) -> acc + elem;
		final int count3 = accumulator.apply(accumulator.apply(accumulator.apply(0, 1), 2), 3);
		System.out.println(count3);
	}

}
