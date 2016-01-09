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
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class FilterPattern {

	public static void main(final String[] args) {
		final List<String> beginningWithNumbers = Stream.of("a", "b", "2abc", "3def")
				.filter(string -> Character.isDigit(string.charAt(0))).collect(Collectors.toList());
		System.out.println(beginningWithNumbers);
	}

}
