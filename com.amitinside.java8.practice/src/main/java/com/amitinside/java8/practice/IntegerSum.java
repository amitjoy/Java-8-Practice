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

import static java.util.stream.Collectors.toList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class IntegerSum {

	private static final int size = Integer.getInteger("sum.size", 1000000);

	public int[] array;
	public List<Integer> arrayList;
	public HashSet<Integer> hashSet;
	public LinkedList<Integer> linkedList;
	public TreeSet<Integer> treeSet;

	// BEGIN addIntegers
	private int addIntegers(final List<Integer> values) {
		return values.parallelStream().mapToInt(i -> i).sum();
	}
	// END addIntegers

	public int array() {
		return IntStream.of(this.array).parallel().sum();
	}

	public int arrayList() {
		return this.arrayList.parallelStream().mapToInt(i -> i).sum();
	}

	public void createDataSources() {
		this.array = IntStream.range(0, size).toArray();
		this.arrayList = this.numbers().collect(toList());
		this.linkedList = new LinkedList<>(this.arrayList);
		this.treeSet = new TreeSet<>(this.arrayList);
		this.hashSet = new HashSet<>(this.arrayList);
	}

	public int hashSet() {
		return this.hashSet.parallelStream().mapToInt(i -> i).sum();
	}

	public int linkedList() {
		return this.linkedList.parallelStream().mapToInt(i -> i).sum();
	}

	private Stream<Integer> numbers() {
		return IntStream.range(0, size).mapToObj(i -> i);
	}

	public int range() {
		return IntStream.range(0, size).parallel().sum();
	}

	public int serialArray() {
		return IntStream.of(this.array).sum();
	}

	public int serialArrayList() {
		return this.arrayList.stream().mapToInt(i -> i).sum();
	}

	public int serialHashSet() {
		return this.hashSet.stream().mapToInt(i -> i).sum();
	}

	public int serialLinkedList() {
		return this.linkedList.stream().mapToInt(i -> i).sum();
	}

	public int serialRange() {
		return IntStream.range(0, size).sum();
	}

	public int serialTreeSet() {
		return this.treeSet.stream().mapToInt(i -> i).sum();
	}

	public int treeSet() {
		return this.treeSet.parallelStream().mapToInt(i -> i).sum();
	}

}
