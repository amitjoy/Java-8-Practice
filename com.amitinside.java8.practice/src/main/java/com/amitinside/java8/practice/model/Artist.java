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
package com.amitinside.java8.practice.model;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Domain class for a popular music artist.
 */
public final class Artist {

	private final List<Artist> members;
	private final String name;
	private final String nationality;

	public Artist(final String name, final List<Artist> members, final String nationality) {
		requireNonNull(name);
		requireNonNull(members);
		requireNonNull(nationality);
		this.name = name;
		this.members = new ArrayList<>(members);
		this.nationality = nationality;
	}

	public Artist(final String name, final String nationality) {
		this(name, Collections.emptyList(), nationality);
	}

	public Artist copy() {
		final List<Artist> members = this.getMembers().map(Artist::copy).collect(toList());
		return new Artist(this.name, members, this.nationality);
	}

	/**
	 * @return the members
	 */
	public Stream<Artist> getMembers() {
		return this.members.stream();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return this.nationality;
	}

	public boolean isFrom(final String nationality) {
		return this.nationality.equals(nationality);
	}

	public boolean isSolo() {
		return this.members.isEmpty();
	}

	@Override
	public String toString() {
		return this.getName();
	}

}
