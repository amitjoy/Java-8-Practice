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

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

public final class UnitTesting {

	public static List<String> allToUpperCase(final List<String> strings) {
		return strings.stream().map(String::toUpperCase).collect(Collectors.toList());
	}

	public static List<String> elementFirstToUpperCase(final List<String> strings) {
		return strings.stream().map(value -> {
			final char firstChar = Character.toUpperCase(value.charAt(0));
			return firstChar + value.substring(1);
		}).collect(Collectors.toList());
	}

	@Test
	public void multipleWordsToUpperCase() {
		final List<String> input = Lists.newArrayList("a", "b", "c");
		final List<String> result = allToUpperCase(input);
		Assert.assertArrayEquals(Lists.newArrayList("A", "B", "C").toArray(), result.toArray());
	}

	@Test
	public void twoLetterStringConvertedToUpperCaseLambdas() {
		final List<String> input = Lists.newArrayList("ab");
		final List<String> result = elementFirstToUpperCase(input);
		Assert.assertArrayEquals(Lists.newArrayList("Ab").toArray(), result.toArray());
	}

}
