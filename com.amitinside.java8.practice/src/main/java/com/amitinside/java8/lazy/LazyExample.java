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
package com.amitinside.java8.lazy;

import com.amitinside.java8.design.pattern.decorator.Candidate;

public final class LazyExample {

	public static void main(final String[] args) {
		final Lazy<Candidate> lazyCandidate = Lazy.of();
		final Candidate candidate = lazyCandidate.get(() -> new Candidate("AMIT"));
		System.out.println(candidate);
	}

}
