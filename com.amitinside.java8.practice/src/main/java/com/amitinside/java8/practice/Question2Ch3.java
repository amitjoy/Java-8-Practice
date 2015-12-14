package com.amitinside.java8.practice;

import java.util.List;

import com.amitinside.java8.practice.model.Artist;

public final class Question2Ch3 {

	public static int countBandMembersInternal(final List<Artist> artists) {
		// return artists.stream().count();
		return artists.stream().map(artist -> artist.getMembers().count()).reduce(0L, Long::sum).intValue();
	}

}
