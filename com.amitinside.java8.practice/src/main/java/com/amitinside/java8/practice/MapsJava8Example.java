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

import java.util.Map;

import com.amitinside.java8.practice.model.Artist;
import com.google.common.collect.Maps;

public final class MapsJava8Example {

	private static Map<String, Artist> artists = Maps.newHashMap();

	public static Artist getArtist(final String name) {
		return artists.computeIfAbsent(name, (artistName) -> new Artist(artistName, "Indian"));
	}

	public static void iterateMap(final Map<Artist, Integer> maps) {
		maps.forEach((artist, noOfAlbums) -> {
			System.out.println(artist);
		});
	}

}
