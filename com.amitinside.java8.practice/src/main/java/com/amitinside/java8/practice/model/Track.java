package com.amitinside.java8.practice.model;

public final class Track {

	private final int length;
	private final String name;

	public Track(final String name, final int length) {
		this.name = name;
		this.length = length;
	}

	public Track copy() {
		return new Track(this.name, this.length);
	}

	/**
	 * @return the length of the track in milliseconds.
	 */
	public int getLength() {
		return this.length;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

}
