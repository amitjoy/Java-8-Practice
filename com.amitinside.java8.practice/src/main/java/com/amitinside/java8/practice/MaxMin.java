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

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.amitinside.java8.practice.model.Track;

public final class MaxMin {

	public static void main(final String[] args) {
		final List<Track> tracks = Arrays.asList(new Track("Bakai", 524), new Track("Violets Your Furs", 378),
				new Track("Time Was", 451));
		final Track shortTrack = tracks.stream().min(Comparator.comparingInt(track -> track.getLength())).get();
		final Track longTrack = tracks.stream().max(Comparator.comparing(Track::getLength)).get();
		System.out.println(shortTrack.getName());
		System.out.println(longTrack.getName());
	}

}
