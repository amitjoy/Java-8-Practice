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

import java.util.List;
import java.util.function.ToLongFunction;

import com.amitinside.java8.practice.model.Album;
import com.amitinside.java8.practice.model.Track;
import com.google.common.collect.Lists;

public final class BoilerPlateCodeRefactoring {

	private final List<Album> albums = Lists.newArrayList();

	public long countFeature(final ToLongFunction<Album> function) {
		return this.albums.stream().mapToLong(function).sum();
	}

	public long countMusicians_1() {
		long count = 0;
		for (final Album album : this.albums) {
			count += album.getMusicianList().size();
		}
		return count;
	}

	public long countMusicians_2() {
		return this.albums.stream().mapToLong(album -> album.getMusicianList().stream().count()).sum();
	}

	public long countMusicians_3() {
		return this.albums.stream().flatMap(album -> album.getAllMusicians()).count();
	}

	public long countMusicians_4() {
		return this.countFeature(album -> album.getAllMusicians().count());
	}

	// Boilerplate
	public long countRunningTime_1() {
		long count = 0;
		for (final Album album : this.albums) {
			for (final Track track : album.getTrackList()) {
				count += track.getLength();
			}
		}
		return count;
	}

	public long countRunningTime_2() {
		return this.albums.stream().flatMap(album -> album.getTracks()).mapToLong(track -> track.getLength()).sum();
	}

	public long countRunningTime_3() {
		return this.albums.stream()
				.mapToLong(album -> album.getTrackList().stream().mapToLong(track -> track.getLength()).sum()).sum();
	}

	public long countRunningTime_4() {
		return this.countFeature(album -> album.getTrackList().stream().mapToLong(track -> track.getLength()).sum());
	}

	public long countTracks_1() {
		long count = 0;
		for (final Album album : this.albums) {
			count += album.getTrackList().size();
		}
		return count;
	}

	public long countTracks_2() {
		return this.albums.stream().flatMap(album -> album.getTracks()).count();
	}

	public long countTracks_3() {
		return this.albums.stream().mapToLong(album -> album.getTrackList().stream().count()).sum();
	}

	public long countTracks_4() {
		return this.countFeature(album -> album.getTracks().count());
	}

}
