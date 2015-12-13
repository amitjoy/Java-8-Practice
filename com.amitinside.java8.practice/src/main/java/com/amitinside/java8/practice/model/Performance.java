package com.amitinside.java8.practice.model;

import static java.util.stream.Stream.concat;

import java.util.stream.Stream;

public interface Performance {

	public default Stream<Artist> getAllMusicians() {
		return getMusicians().flatMap(artist -> {
			return concat(Stream.of(artist), artist.getMembers());
		});
	}

	public Stream<Artist> getMusicians();

	public String getName();

}
