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

import static org.jooq.lambda.Agg.allBy;
import static org.jooq.lambda.Agg.anyBy;
import static org.jooq.lambda.Agg.max;
import static org.jooq.lambda.Agg.maxBy;
import static org.jooq.lambda.Agg.median;
import static org.jooq.lambda.Agg.min;
import static org.jooq.lambda.Agg.minBy;
import static org.jooq.lambda.Agg.noneBy;
import static org.jooq.lambda.Agg.percentile;
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
		assertEquals(true, Seq.of(0, 3).allMatch(i -> (i % 3) == 0));
		assertEquals(false, Seq.of(1, 2, 3, 4).collect(noneBy(i -> (i % 3) == 0)));
		assertEquals(false, Seq.of(1, 2, 3, 4).noneMatch(i -> (i % 3) == 0));
		assertEquals(true, Seq.of(1, 2, 3, 4, 5).collect(anyBy(i -> (i % 3) == 0)));

		assertEquals(Optional.of(1), Stream.of(1, 2).collect(median()));
		assertEquals(Optional.of(2), Stream.of(1, 2, 3).collect(median()));
		assertEquals(Optional.of(2), Stream.of(1, 2, 3, 4).collect(median()));
		assertEquals(Optional.of(3), Stream.of(1, 2, 3, 4, 10).collect(median()));
		assertEquals(Optional.of(3), Stream.of(1, 2, 3, 4, 10, 9).collect(median()));
		assertEquals(Optional.of(3), Stream.of(1, 2, 3, 4, 10, 9, 3).collect(median()));
		assertEquals(Optional.of(3), Stream.of(1, 2, 3, 4, 10, 9, 3, 3).collect(median()));
		assertEquals(Optional.of(3), Stream.of(1, 2, 3, 4, 10, 9, 3, 3, 20).collect(median()));
		assertEquals(Optional.of(3), Stream.of(1, 2, 3, 4, 10, 9, 3, 3, 20, 21).collect(median()));
		assertEquals(Optional.of(4), Stream.of(1, 2, 3, 4, 10, 9, 3, 3, 20, 21, 22).collect(median()));

		// Min
		assertEquals(Optional.empty(), Stream.<Integer> of().collect(percentile(0.0)));
		assertEquals(Optional.of(1), Stream.of(1).collect(percentile(0.0)));
		assertEquals(Optional.of(1), Stream.of(1, 2).collect(percentile(0.0)));
		assertEquals(Optional.of(1), Stream.of(1, 2, 3).collect(percentile(0.0)));
		assertEquals(Optional.of(1), Stream.of(1, 2, 3, 4).collect(percentile(0.0)));
		assertEquals(Optional.of(1), Stream.of(1, 2, 3, 4, 10).collect(percentile(0.0)));
		assertEquals(Optional.of(1), Stream.of(1, 2, 3, 4, 10, 9).collect(percentile(0.0)));
		assertEquals(Optional.of(1), Stream.of(1, 2, 3, 4, 10, 9, 3).collect(percentile(0.0)));
		assertEquals(Optional.of(1), Stream.of(1, 2, 3, 4, 10, 9, 3, 3).collect(percentile(0.0)));
		assertEquals(Optional.of(1), Stream.of(1, 2, 3, 4, 10, 9, 3, 3, 20).collect(percentile(0.0)));

		// 0.25 percentile
		assertEquals(Optional.empty(), Stream.<Integer> of().collect(percentile(0.25)));
		assertEquals(Optional.of(1), Stream.of(1).collect(percentile(0.25)));
		assertEquals(Optional.of(1), Stream.of(1, 2).collect(percentile(0.25)));
		assertEquals(Optional.of(1), Stream.of(1, 2, 3).collect(percentile(0.25)));
		assertEquals(Optional.of(1), Stream.of(1, 2, 3, 4).collect(percentile(0.25)));
		assertEquals(Optional.of(2), Stream.of(1, 2, 3, 4, 10).collect(percentile(0.25)));
		assertEquals(Optional.of(2), Stream.of(1, 2, 3, 4, 10, 9).collect(percentile(0.25)));
		assertEquals(Optional.of(2), Stream.of(1, 2, 3, 4, 10, 9, 3).collect(percentile(0.25)));

		// Median
		assertEquals(Optional.empty(), Stream.<Integer> of().collect(percentile(0.5)));
		assertEquals(Optional.of(1), Stream.of(1).collect(percentile(0.5)));
		assertEquals(Optional.of(1), Stream.of(1, 2).collect(percentile(0.5)));
		assertEquals(Optional.of(2), Stream.of(1, 2, 3).collect(percentile(0.5)));
		assertEquals(Optional.of(2), Stream.of(1, 2, 3, 4).collect(percentile(0.5)));
		assertEquals(Optional.of(3), Stream.of(1, 2, 3, 4, 10).collect(percentile(0.5)));
		assertEquals(Optional.of(3), Stream.of(1, 2, 3, 4, 10, 9).collect(percentile(0.5)));
		assertEquals(Optional.of(3), Stream.of(1, 2, 3, 4, 10, 9, 3).collect(percentile(0.5)));
		assertEquals(Optional.of(3), Stream.of(1, 2, 3, 4, 10, 9, 3, 3).collect(percentile(0.5)));

		// 0.75 percentile
		assertEquals(Optional.empty(), Stream.<Integer> of().collect(percentile(0.75)));
		assertEquals(Optional.of(1), Stream.of(1).collect(percentile(0.75)));
		assertEquals(Optional.of(2), Stream.of(1, 2).collect(percentile(0.75)));
		assertEquals(Optional.of(3), Stream.of(1, 2, 3).collect(percentile(0.75)));
		assertEquals(Optional.of(3), Stream.of(1, 2, 3, 4).collect(percentile(0.75)));
		assertEquals(Optional.of(4), Stream.of(1, 2, 3, 4, 10).collect(percentile(0.75)));
		assertEquals(Optional.of(9), Stream.of(1, 2, 3, 4, 10, 9).collect(percentile(0.75)));
		assertEquals(Optional.of(9), Stream.of(1, 2, 3, 4, 10, 9, 3).collect(percentile(0.75)));
		assertEquals(Optional.of(4), Stream.of(1, 2, 3, 4, 10, 9, 3, 3).collect(percentile(0.75)));

		// Max
		assertEquals(Optional.empty(), Stream.<Integer> of().collect(percentile(1.0)));
		assertEquals(Optional.of(1), Stream.of(1).collect(percentile(1.0)));
		assertEquals(Optional.of(2), Stream.of(1, 2).collect(percentile(1.0)));
		assertEquals(Optional.of(3), Stream.of(1, 2, 3).collect(percentile(1.0)));
		assertEquals(Optional.of(4), Stream.of(1, 2, 3, 4).collect(percentile(1.0)));
		assertEquals(Optional.of(10), Stream.of(1, 2, 3, 4, 10).collect(percentile(1.0)));
		assertEquals(Optional.of(10), Stream.of(1, 2, 3, 4, 10, 9).collect(percentile(1.0)));
		assertEquals(Optional.of(10), Stream.of(1, 2, 3, 4, 10, 9, 3).collect(percentile(1.0)));
		assertEquals(Optional.of(10), Stream.of(1, 2, 3, 4, 10, 9, 3, 3).collect(percentile(1.0)));
		assertEquals(Optional.of(20), Stream.of(1, 2, 3, 4, 10, 9, 3, 3, 20).collect(percentile(1.0)));

		System.out.println(Stream.of(1, 2, 3, 4).collect(allBy(num -> (num % 2) == 0)));
		System.out.println(alphabet);
		System.out.println(strings);
	}

}
