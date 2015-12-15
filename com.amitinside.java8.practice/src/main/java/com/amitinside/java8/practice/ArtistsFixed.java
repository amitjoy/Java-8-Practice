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

import java.util.List;
import java.util.Optional;

import com.amitinside.java8.practice.model.Artist;

public class ArtistsFixed {

	private final List<Artist> artists;

	public ArtistsFixed(final List<Artist> artists) {
		this.artists = artists;
	}

	public Optional<Artist> getArtist(final int index) {
		if ((index < 0) || (index >= this.artists.size())) {
			return Optional.empty();
		}
		return Optional.of(this.artists.get(index));
	}

	public String getArtistName(final int index) {
		final Optional<Artist> artist = this.getArtist(index);
		return artist.map(Artist::getName).orElse("unknown");
	}

}
