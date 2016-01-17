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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.amitinside.java8.practice.model.Album;
import com.amitinside.java8.practice.model.Artist;
import com.amitinside.java8.practice.model.Track;

public final class CompletableAlbumLookup implements AlbumLookup {

	private static final ExecutorService service = Executors.newFixedThreadPool(4);

	private Artist artist;
	private final List<Artist> artists;

	// Variables Exists to satisfy code sample below
	private Track track;

	private final List<Track> tracks;

	public CompletableAlbumLookup(final List<Track> tracks, final List<Artist> artists) {
		this.tracks = tracks;
		this.artists = artists;
	}

	// BEGIN createFuture
	CompletableFuture<Artist> createFuture(final String id) {
		final CompletableFuture<Artist> future = new CompletableFuture<>();
		this.startJob(future);
		return future;
	}
	// END createFuture

	private CompletableFuture<Credentials> loginTo(final String serviceName) {
		return CompletableFuture.supplyAsync(() -> {
			if ("artist".equals(serviceName)) {
				this.sleep(1000);
			}
			return new Credentials();
		} , service);
	}

	private CompletableFuture<List<Artist>> lookupArtists(final String albumName, final Credentials credentials) {
		return CompletableFuture.completedFuture(this.artists);
	}

	// BEGIN lookupByName
	@Override
	public Album lookupByName(final String albumName) {
		final CompletableFuture<List<Artist>> artistLookup = this.loginTo("artist")
				.thenCompose(artistLogin -> this.lookupArtists(albumName, artistLogin)); // <1>

		return this.loginTo("track").thenCompose(trackLogin -> this.lookupTracks(albumName, trackLogin)) // <2>
				.thenCombine(artistLookup, (tracks, artists) -> new Album(albumName, tracks, artists)) // <3>
				.join(); // <4>
	}
	// END lookupByName

	// BEGIN lookupTrack
	CompletableFuture<Track> lookupTrack(final String id) {
		return CompletableFuture.supplyAsync(() -> {
			// Some expensive work is done here <1>
			// ...
			return this.track; // <2>
		} , service); // <3>
	}
	// END lookupTrack

	// ----------------- FAKE LOOKUP METHODS -----------------
	// Represent API lookup on external services

	private CompletableFuture<List<Track>> lookupTracks(final String albumName, final Credentials credentials) {
		return CompletableFuture.supplyAsync(() -> {
			this.sleep(1000);
			return this.tracks;
		} , service);
	}

	private void processExceptionally(final CompletableFuture<Album> future, final String name) {
		// BEGIN completeExceptionally
		future.completeExceptionally(new AlbumLookupException("Unable to find " + name));
		// END completeExceptionally
	}

	private void sleep(final long time) {
		try {
			Thread.sleep(time);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void startJob(final CompletableFuture<Artist> future) {
		// BEGIN complete
		future.complete(this.artist);
		// END complete
	}

}
