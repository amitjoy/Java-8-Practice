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

import java.util.List;

import com.amitinside.java8.practice.model.Artist;

public final class PrettyPrintExamples {

	public void prettyPrintArtistsNames1(final List<Artist> artists) {
		final StringBuilder reduced = artists.stream().map(Artist::getName).reduce(new StringBuilder(),
				(builder, name) -> {
					if (builder.length() > 0) {
						builder.append(", ");
					}

					builder.append(name);
					return builder;
				} , (left, right) -> left.append(right));

		reduced.insert(0, "[");
		reduced.append("]");

		System.out.println(reduced.toString());
	}

	public String prettyPrintArtistsNames2(final List<Artist> artists) {
		return artists.stream().map(Artist::getName).collect(new StringCollector(", ", "[", "]"));
	}

}
