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
package com.amitinside.java8.practice;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.amitinside.java8.practice.model.Album;
import com.amitinside.java8.practice.model.Artist;

public final class LoggingIntermediateValues {

	public Set<String> findCountryOfOriginForEveryArtistOnAlbum1(final Album album) {
		final Set<String> nationalities = new HashSet<>();
		for (final Artist artist : album.getMusicianList()) {
			final String nationality = artist.getNationality();
			System.out.println("Found Nationality ===>" + nationality);
			nationalities.add(nationality);
		}
		return nationalities;
	}

	public Set<String> findCountryOfOriginForEveryArtistOnAlbum2(final Album album) {
		return album.getAllMusicians().map(Artist::getNationality).collect(Collectors.toSet());
	}

	public Set<String> findCountryOfOriginForEveryArtistOnAlbum3(final Album album) {
		album.getAllMusicians().map(Artist::getNationality).forEach(System.out::println);
		return album.getAllMusicians().map(Artist::getNationality).collect(Collectors.toSet());
	}

	public Set<String> findCountryOfOriginForEveryArtistOnAlbum4(final Album album) {
		return album.getAllMusicians().map(Artist::getNationality).peek(System.out::println)
				.collect(Collectors.toSet());
	}

}
