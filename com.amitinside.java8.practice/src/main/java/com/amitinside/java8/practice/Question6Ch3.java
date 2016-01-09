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
