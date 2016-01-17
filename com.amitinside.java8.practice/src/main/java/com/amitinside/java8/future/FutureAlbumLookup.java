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
package com.amitinside.java8.future;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.amitinside.java8.practice.model.Album;
import com.amitinside.java8.practice.model.Artist;
import com.amitinside.java8.practice.model.Track;

public final class FutureAlbumLookup implements AlbumLookup {

	private static final ExecutorService service = Executors.newFixedThreadPool(2);

	private final List<Artist> artists;
	private final List<Track> tracks;

	public FutureAlbumLookup(final List<Track> tracks, final List<Artist> artists) {
		this.tracks = tracks;
		this.artists = artists;
	}

	private void fakeWaitingForExternalWebService() throws InterruptedException {
		Thread.sleep(1000);
	}

	private Future<Credentials> loginTo(final String serviceName) {
		return service.submit(() -> {
			if ("track".equals(serviceName)) {
				this.fakeWaitingForExternalWebService();
			}
			return new Credentials();
		});
	}

	private Future<List<Artist>> lookupArtists(final String albumName, final Credentials credentials) {
		return service.submit(() -> {
			this.fakeWaitingForExternalWebService();
			return this.artists;
		});
	}

	@Override
	public Album lookupByName(final String albumName) {
		final Future<Credentials> trackLogin = this.loginTo("track"); // <1>
		final Future<Credentials> artistLogin = this.loginTo("artist");

		try {
			final Future<List<Track>> tracks = this.lookupTracks(albumName, trackLogin.get()); // <2>
			final Future<List<Artist>> artists = this.lookupArtists(albumName, artistLogin.get());

			return new Album(albumName, tracks.get(), artists.get()); // <3>
		} catch (InterruptedException | ExecutionException e) {
			throw new AlbumLookupException(e.getCause()); // <4>
		}
	}

	private Future<List<Track>> lookupTracks(final String albumName, final Credentials credentials) {
		return service.submit(() -> {
			return this.tracks;
		});
	}

}
