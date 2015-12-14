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
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.amitinside.java8.practice.model.Album;
import com.amitinside.java8.practice.model.Artist;

public final class Question1Ch3 {

	public static int addUpNumbers(final List<Integer> numbers) {
		return numbers.stream().reduce(0, (acc, elem) -> acc + elem);
	}

	public static List<Album> getAlbumsWithAtMostThreeTracks(final List<Album> albums) {
		return albums.stream().filter(album -> album.getTracks().count() <= 3).collect(Collectors.toList());
	}

	public static List<String> getNamesAndOrigins(final List<Artist> artists) {
		return artists.stream().flatMap(artist -> Stream.of(artist.getNationality(), artist.getName()))
				.collect(Collectors.toList());
	}
}
