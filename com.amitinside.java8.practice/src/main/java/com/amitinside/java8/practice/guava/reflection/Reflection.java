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
package com.amitinside.java8.practice.guava.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import com.amitinside.java8.design.pattern.decorator.Candidate;
import com.google.common.collect.Lists;
import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeToken;
import com.sun.istack.internal.Nullable;

public class Reflection {

	public static void main(final String[] args) throws NoSuchMethodException, SecurityException {
		final List<String> stringList = Lists.newArrayList();
		final List<Integer> intList = Lists.newArrayList();
		System.out.println(stringList.getClass().isAssignableFrom(intList.getClass()));
		// returns true, even though ArrayList<String> is not assignable from
		// ArrayList<Integer>

		TypeToken.of(String.class);
		TypeToken.of(Integer.class);
		final TypeToken<List<String>> stringListTok = new TypeToken<List<String>>() {

		};
		final TypeToken<List<Integer>> integerListTok = new TypeToken<List<Integer>>() {
		};
		System.out.println(stringListTok.isSupertypeOf(integerListTok));
		final Candidate candidate = new Candidate("AMIT");
		final Method getMethod = Arrays.stream(candidate.getClass().getMethods())
				.filter(method -> method.isAnnotationPresent(Nullable.class)).findFirst().get();
		final Invokable<List<String>, ?> invokable = new TypeToken<List<String>>() {
		}.method(getMethod);
		System.out.println(invokable.isStatic());

	}

}
