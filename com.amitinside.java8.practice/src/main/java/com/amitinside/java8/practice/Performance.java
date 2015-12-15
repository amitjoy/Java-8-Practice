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

import java.util.stream.Stream;

import com.amitinside.java8.practice.model.Artist;

/** A Performance by some musicians - e.g., an Album or Gig. */
public interface Performance {

	public default Stream<Artist> getAllMusicians() {
		return getMusicians().flatMap(artist -> Stream.concat(Stream.of(artist), artist.getMembers()));
	}

	public Stream<Artist> getMusicians();

	public String getName();

}