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
