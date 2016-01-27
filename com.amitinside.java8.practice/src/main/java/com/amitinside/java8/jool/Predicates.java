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
package com.amitinside.java8.jool;

import java.util.function.Predicate;

import org.jooq.lambda.function.Functions;

public final class Predicates {

	public static void main(final String[] args) {
		final Predicate<Integer> predicate1 = num -> (num % 2) == 0;
		final Predicate<Integer> predicate2 = num -> (num % 3) == 0;

		System.out.println(Functions.and(predicate1, predicate2).test(6));
		System.out.println(Functions.or(predicate1, predicate2).test(3));
	}

}
