package com.amitinside.java8.practice.model;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Domain class for a popular music artist.
 */
public final class Artist {

	private final List<Artist> members;
	private final String name;
	private final String nationality;

	public Artist(final String name, final List<Artist> members, final String nationality) {
		requireNonNull(name);
		requireNonNull(members);
		requireNonNull(nationality);
		this.name = name;
		this.members = new ArrayList<>(members);
		this.nationality = nationality;
	}

	public Artist(final String name, final String nationality) {
		this(name, Collections.emptyList(), nationality);
	}

	public Artist copy() {
		final List<Artist> members = this.getMembers().map(Artist::copy).collect(toList());
		return new Artist(this.name, members, this.nationality);
	}

	/**
	 * @return the members
	 */
	public Stream<Artist> getMembers() {
		return this.members.stream();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return this.nationality;
	}

	public boolean isFrom(final String nationality) {
		return this.nationality.equals(nationality);
	}

	public boolean isSolo() {
		return this.members.isEmpty();
	}

	@Override
	public String toString() {
		return this.getName();
	}

}
