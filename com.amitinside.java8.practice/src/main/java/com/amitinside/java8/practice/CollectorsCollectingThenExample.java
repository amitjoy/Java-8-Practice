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

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;

public final class CollectorsCollectingThenExample {

	public static void main(final String[] args) {
		final List<String> names = newArrayList("Amit", "Kumar", "Mondal", "Baishali", "Dutta");
		final List<String> results = names.stream().filter(name -> name.length() == 5)
				.collect(collectingAndThen(toList(), Collections::unmodifiableList));
		System.out.println(results);
	}

}
