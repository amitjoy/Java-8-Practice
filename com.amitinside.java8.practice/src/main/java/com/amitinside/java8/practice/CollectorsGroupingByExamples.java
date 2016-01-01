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

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.amitinside.java8.practice.model.Student;

public final class CollectorsGroupingByExamples {

	public static void main(final String[] args) {
		final Student s1 = new Student("Ram", "A", 20);
		final Student s2 = new Student("Shyam", "B", 22);
		final Student s3 = new Student("Mohan", "A", 22);
		final Student s4 = new Student("Mahesh", "C", 20);
		final Student s5 = new Student("Krishna", "B", 21);
		final List<Student> list = Arrays.asList(s1, s2, s3, s4, s5);
		// Group Student on the basis of ClassName
		System.out.println("----Group Student on the basis of ClassName----");
		final Map<String, List<Student>> stdByClass = list.stream()
				.collect(Collectors.groupingBy(Student::getClassName));

		stdByClass.forEach((k, v) -> System.out
				.println("Key:" + k + "  " + v.stream().map(m -> m.getName()).collect(Collectors.joining(","))));

		// Group Student on the basis of age
		System.out.println("----Group Student on the basis of age----");
		final Map<Integer, List<Student>> stdByAge = list.stream().collect(Collectors.groupingBy(Student::getAge));

		stdByAge.forEach((k, v) -> System.out
				.println("Key:" + k + "  " + v.stream().map(m -> m.getName()).collect(Collectors.joining(","))));
	}
}