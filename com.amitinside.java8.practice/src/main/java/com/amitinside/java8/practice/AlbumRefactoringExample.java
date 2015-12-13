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
import java.util.Set;
import java.util.stream.Collectors;

import com.amitinside.java8.practice.model.Album;
import com.google.common.collect.Sets;

public final class AlbumRefactoringExample {

	/**
	 * First version of refactoring
	 */
	public Set<String> findLongTracks1(final List<Album> albums) {
		final Set<String> trackNames = Sets.newHashSet();
		albums.stream().forEach(album -> {
			album.getTracks().forEach(track -> {
				if (track.getLength() > 60) {
					trackNames.add(track.getName());
				}
			});
		});
		return trackNames;
	}

	/**
	 * Second version of refactoring
	 */
	public Set<String> findLongTracks2(final List<Album> albums) {
		final Set<String> trackNames = Sets.newHashSet();
		albums.stream().forEach(album -> {
			album.getTracks().filter(track -> track.getLength() > 60).map(track -> track.getName())
					.forEach(track -> trackNames.add(track));
		});
		return trackNames;
	}

	/**
	 * Third version of refactoring
	 */
	public Set<String> findLongTracks3(final List<Album> albums) {
		final Set<String> trackNames = Sets.newHashSet();
		albums.stream().flatMap(album -> album.getTracks()).filter(track -> track.getLength() > 60)
				.map(track -> track.getName()).forEach(track -> trackNames.add(track));
		return trackNames;
	}

	/**
	 * Fourth version of refactoring
	 */
	public Set<String> findLongTracks4(final List<Album> albums) {
		return albums.stream().flatMap(album -> album.getTracks()).filter(track -> track.getLength() > 60)
				.map(track -> track.getName()).collect(Collectors.toSet());
	}

}
