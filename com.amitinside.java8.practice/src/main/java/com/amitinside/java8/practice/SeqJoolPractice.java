/*******************************************************************************
 * Copyright 2015 Amit Kumar Mondal
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

import static org.jooq.lambda.Agg.allBy;
import static org.jooq.lambda.Agg.max;
import static org.jooq.lambda.Agg.maxBy;
import static org.jooq.lambda.Agg.min;
import static org.jooq.lambda.Agg.minBy;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.jooq.lambda.Seq;

public final class SeqJoolPractice {

	public static void main(final String[] args) {
		final List<String> alphabet = Seq.rangeClosed('A', 'Z').map(Object::toString).toList();
		final String[] strings = Seq.rangeClosed('a', 'z').map(Object::toString).toArray(String[]::new);

		assertEquals(Optional.of(1), Seq.of(1, 2, 3).collect(min()));
		assertEquals(Optional.of(3), Seq.of(1, 2, 3).collect(max()));
		assertEquals(Optional.of(3), Seq.of(1, 2, 3).collect(minBy(i -> -i)));
		assertEquals(Optional.of(1), Seq.of(1, 2, 3).collect(maxBy(i -> -i)));

		System.out.println(Stream.of(1, 2, 3, 4).collect(allBy(num -> (num % 2) == 0)));
		System.out.println(alphabet);
		System.out.println(strings);
	}

}
