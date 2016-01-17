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

public final class Description {

	private final String name;

	public Description(final String name) {
		super();
		this.name = name;
	}

	public void should(final String description, final Specification specification) {
		try {
			final Expect expect = new Expect();
			specification.specifyBehaviour(expect);
		} catch (final Exception e) {
			// TODO: handle exception
		}
	}

}