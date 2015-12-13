package com.amitinside.java8.practice;

import java.util.List;
import java.util.stream.Collectors;

import com.amitinside.java8.practice.model.Artist;
import com.amitinside.java8.practice.model.MusicChapter;

public class Chapter1 extends MusicChapter {

	public List<Artist> artistsLivingInLondon() {
		return this.artists.stream().filter(artist -> "London".equals(artist.getNationality()))
				.collect(Collectors.toList());
	}

	public List<String> getNamesOfArtists_Lambda() {
		return this.artists.stream().map(artist -> artist.getName()).collect(Collectors.toList());
	}

	public List<String> getNamesOfArtists_MethodReference() {
		return this.artists.stream().map(Artist::getName).collect(Collectors.toList());
	}

}
