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
package com.amitinside.java8.practice.dsl;

import static com.amitinside.java8.practice.dsl.DescribeUtil.describe;

import java.util.Stack;

public final class StackSpec {

	{
		describe("a stack", it -> {
			it.should("be empty when created", expect -> {
				expect.that(new Stack<>().isEmpty());
			});

			it.should("push new elements onto the top of the stack", expect -> {
				final Stack<Integer> stack = new Stack<>();
				stack.push(1);

				expect.that(stack.get(0)).isEqualTo(1);
			});

			it.should("pop the last element pushed onto the stack", expect -> {
				final Stack<Integer> stack = new Stack<>();
				stack.push(2);
				stack.push(1);

				expect.that(stack.pop()).isEqualTo(2);
			});

		});
	}
}
