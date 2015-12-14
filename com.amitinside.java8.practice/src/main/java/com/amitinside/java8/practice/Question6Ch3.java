package com.amitinside.java8.practice;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public final class Question6Ch3 {

	public static int countLowercaseLetters(final String string) {
		return (int) string.chars().filter(character -> Character.isLowerCase(character)).count();
	}

	public static Optional<String> mostLowercaseString(final List<String> strings) {
		return strings.stream().max(Comparator.comparing(Question6Ch3::countLowercaseLetters));
	}

}
