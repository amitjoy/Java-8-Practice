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

public final class StringCombiner {

	private final StringBuilder builder;
	private final String delim;
	private final String prefix;
	private final String suffix;

	public StringCombiner(final String delim, final String prefix, final String suffix) {
		this.delim = delim;
		this.prefix = prefix;
		this.suffix = suffix;
		this.builder = new StringBuilder();
	}

	// BEGIN add
	public StringCombiner add(final String element) {
		if (this.areAtStart()) {
			this.builder.append(this.prefix);
		} else {
			this.builder.append(this.delim);
		}
		this.builder.append(element);
		return this;
	}
	// END add

	private boolean areAtStart() {
		return this.builder.length() == 0;
	}

	// BEGIN merge
	public StringCombiner merge(final StringCombiner other) {
		if (other.builder.length() > 0) {
			if (this.areAtStart()) {
				this.builder.append(this.prefix);
			} else {
				this.builder.append(this.delim);
			}
			this.builder.append(other.builder, this.prefix.length(), other.builder.length());
		}
		return this;
	}
	// END merge

	@Override
	public String toString() {
		if (this.areAtStart()) {
			this.builder.append(this.prefix);
		}
		this.builder.append(this.suffix);
		return this.builder.toString();
	}

}
