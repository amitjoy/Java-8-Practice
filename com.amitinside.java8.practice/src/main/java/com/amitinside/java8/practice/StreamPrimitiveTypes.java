/*******************************************************************************
 * Copyright 2015, 2016 Amit Kumar Mondal
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

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;

import com.amitinside.java8.practice.model.Album;

public final class StreamPrimitiveTypes {

	public static void printTrackLengthStatistics(final Album album) {
		final IntSummaryStatistics trackLengthStats = album.getTracks().mapToInt(track -> track.getLength())
				.summaryStatistics();
		System.out.println("Max: " + trackLengthStats.getMax());
		System.out.println("Min: " + trackLengthStats.getMin());
		System.out.println("Avg: " + trackLengthStats.getAverage());
		System.out.println("Total Length: " + trackLengthStats.getSum());

		final DoubleSummaryStatistics doubleSummaryStatistics = album.getTracks()
				.mapToDouble(track -> track.getLength()).summaryStatistics();
		System.out.println("Max: " + doubleSummaryStatistics.getMax());
		System.out.println("Min: " + doubleSummaryStatistics.getMin());
		System.out.println("Avg: " + doubleSummaryStatistics.getAverage());
		System.out.println("Total Length: " + doubleSummaryStatistics.getSum());
	}

}
