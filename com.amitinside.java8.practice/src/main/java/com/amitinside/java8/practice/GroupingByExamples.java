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
