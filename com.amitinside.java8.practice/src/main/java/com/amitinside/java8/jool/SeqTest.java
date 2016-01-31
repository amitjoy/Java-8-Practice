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

import static com.google.common.collect.Lists.newArrayList;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jooq.lambda.Seq;
import org.junit.Test;

@SuppressWarnings("deprecation")
public final class SeqTest {

	@Test
	public void testAverageMethod() {
		assertEquals(Optional.of(2), Seq.of(1, 2, 3).avg());
	}

	public void testGroupBy() {
		final Map<Integer, List<Integer>> map1 = Seq.of(1, 2, 3, 4).groupBy(i -> i % 2);
		assertEquals(newArrayList(2, 4), map1.get(0));
		assertEquals(newArrayList(1, 3), map1.get(1));
		assertEquals(2, map1.size());
	}

	@Test
	public void testIterable() {
		assertNotNull(Seq.of(1, 2, 3).collect(Collectors.toCollection(LinkedList::new)));
		assertNotNull(Seq.of(1, 2, 3).toList());
		assertEquals(newArrayList(2, 4, 16, 256, 65536), Seq.iterate(2, i -> i * i).limit(5).toList());
	}

	@Test
	public void testOfType() {
		assertEquals(newArrayList(1, 2, 3), Seq.of(1, "a", 2, "b", 3, null).ofType(Integer.class).toList());
		assertEquals(newArrayList(1, "a", 2, "b", 3),
				Seq.of(1, "a", 2, "b", 3, null).ofType(Serializable.class).toList());
	}

}
