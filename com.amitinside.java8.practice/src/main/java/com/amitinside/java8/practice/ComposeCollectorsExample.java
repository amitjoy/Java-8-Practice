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
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.amitinside.java8.practice.model.Album;
import com.amitinside.java8.practice.model.Artist;

public final class ComposeCollectorsExample {

	public Map<Artist, List<String>> albumsForEachArtist(final List<Album> albums) {
		final Function<Album, Artist> classifier = album -> album.getMainMusician();
		return albums.stream()
				.collect(Collectors.groupingBy(classifier, Collectors.mapping(Album::getName, Collectors.toList())));
	}

	public Map<Artist, Long> numberOfAlbums(final List<Album> albums) {
		final Function<Album, Artist> classifier = album -> album.getMainMusician();
		return albums.stream().collect(Collectors.groupingBy(classifier, Collectors.counting()));
	}

	public Map<Artist, List<Album>> numberOfAlbumsForEachArtist(final List<Album> albums) {
		final Function<Album, Artist> classifier = album -> album.getMainMusician();
		return albums.stream().collect(Collectors.groupingBy(classifier));
	}

}