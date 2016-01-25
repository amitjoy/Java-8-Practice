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

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import com.amitinside.java8.practice.model.Person;
import com.google.common.collect.Lists;

public final class GroupingByExamples {

	public static void main(final String[] args) {
		final List<Person> people = Lists.newArrayList(new Person("Amit", 24), new Person("Baishali", 24),
				new Person("Bill", 32), new Person("Jack", 21), new Person("Henry", 23));

		final Function<Person, Character> classifier = person -> person.getName().charAt(0);
		final Map<Character, List<Person>> grouped = people.stream().collect(Collectors.groupingBy(classifier));
		System.out.println(grouped);

		final ToIntFunction<Person> keyExtractor = person -> person.getName().length();
		final Map<Character, Optional<Person>> grouped2 = people.stream()
				.collect(Collectors.groupingBy(classifier, Collectors.maxBy(Comparator.comparingInt(keyExtractor))));
		System.out.println(grouped2);
	}

}
