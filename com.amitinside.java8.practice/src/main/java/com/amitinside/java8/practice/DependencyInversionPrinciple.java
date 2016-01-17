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
package com.amitinside.java8.practice;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public final class DependencyInversionPrinciple {

	public static class ExtractedDIP implements HeadingFinder {
		@Override
		public List<String> findHeadings(final Reader input) {
			return this.withLinesOf(
					input, lines -> lines.filter(line -> line.endsWith(":"))
							.map(line -> line.substring(0, line.length() - 1)).collect(toList()),
					HeadingLookupException::new);
		}

		private <T> T withLinesOf(final Reader input, final Function<Stream<String>, T> handler,
				final Function<IOException, RuntimeException> error) {

			try (BufferedReader reader = new BufferedReader(input)) {
				return handler.apply(reader.lines());
			} catch (final IOException e) {
				throw error.apply(e);
			}
		}
	}

	@FunctionalInterface
	public static interface HeadingFinder {
		public List<String> findHeadings(Reader reader);
	}

	public static class NoDIP implements HeadingFinder {
		@Override
		public List<String> findHeadings(final Reader input) {
			try (BufferedReader reader = new BufferedReader(input)) {
				return reader.lines().filter(line -> line.endsWith(":"))
						.map(line -> line.substring(0, line.length() - 1)).collect(toList());
			} catch (final IOException e) {
				throw new HeadingLookupException(e);
			}
		}
	}

}
