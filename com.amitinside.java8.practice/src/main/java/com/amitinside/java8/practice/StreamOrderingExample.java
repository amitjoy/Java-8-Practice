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

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class StreamOrderingExample {

	public static void main(final String[] args) {
		final List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		final List<Integer> sameOrder = numbers.stream().collect(Collectors.toList());

		System.out.println(sameOrder);

		final Set<Integer> numbers2 = Sets.newHashSet(4, 3, 2, 1);
		final List<Integer> notSameOrder = numbers2.stream().collect(Collectors.toList());

		System.out.println(notSameOrder);

		final List<Integer> orderedNumbers = Lists.newArrayList(1, 2, 3, 4);
		final List<Integer> stillOrderedNumbers = orderedNumbers.stream().map(num -> num + 1)
				.collect(Collectors.toList());

		System.out.println(stillOrderedNumbers);

		final Set<Integer> unorderedNumbers = Sets.newHashSet(2, 3, 4, 5);
		final List<Integer> stillUnorderedNumbers = unorderedNumbers.stream().map(num -> num + 1)
				.collect(Collectors.toList());

		System.out.println(stillUnorderedNumbers);
	}

}
