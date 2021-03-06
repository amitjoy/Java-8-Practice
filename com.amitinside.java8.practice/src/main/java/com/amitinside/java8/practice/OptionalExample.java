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

import java.util.Optional;

public final class OptionalExample {

	public static void main(final String[] args) {
		final Optional<String> str = Optional.of("AMIT");
		final Optional<String> empty = Optional.empty();
		final Optional<String> alsoEmpty = Optional.ofNullable(null);
		System.out.println(str.get());
		System.out.println(empty.isPresent());
		System.out.println(alsoEmpty.isPresent());
		System.out.println(alsoEmpty.orElse("HELLO"));
		System.out.println(alsoEmpty.orElseGet(() -> new String("BB")));

	}

}
