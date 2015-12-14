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
package com.amitinside.java8.practice.model;

import static java.util.Collections.unmodifiableList;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class Album implements Performance {

	private final List<Artist> musicians;
	private final String name;
	private final List<Track> tracks;

	public Album(final String name, final List<Track> tracks, final List<Artist> musicians) {
		requireNonNull(name);
		requireNonNull(tracks);
		requireNonNull(musicians);

		this.name = name;
		this.tracks = new ArrayList<>(tracks);
		this.musicians = new ArrayList<>(musicians);
	}

	public Album copy() {
		final List<Track> tracks = this.getTracks().map(Track::copy).collect(toList());
		final List<Artist> musicians = this.getMusicians().map(Artist::copy).collect(toList());
		return new Album(this.name, tracks, musicians);
	}

	public Artist getMainMusician() {
		return this.musicians.get(0);
	}

	/**
	 * Used in imperative code examples that need to iterate over a list
	 */
	public List<Artist> getMusicianList() {
		return unmodifiableList(this.musicians);
	}

	/**
	 * @return the musicians
	 */
	@Override
	public Stream<Artist> getMusicians() {
		return this.musicians.stream();
	}

	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * Used in imperative code examples that need to iterate over a list
	 */
	public List<Track> getTrackList() {
		return unmodifiableList(this.tracks);
	}

	/**
	 * @return the tracks
	 */
	public Stream<Track> getTracks() {
		return this.tracks.stream();
	}

}
