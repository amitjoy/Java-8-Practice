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
package com.amitinside.java8.concurrency;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import com.google.common.base.Throwables;
import com.google.common.collect.Lists;

public final class CompletableFutureInAction {

	private static final ExecutorService executor = Executors.newFixedThreadPool(4);

	private static final Logger logger = LoggerFactory.getLogger(CompletableFutureInAction.class);

	private static CompletableFuture<Double> calculateRelevance(final Document doc) {
		return null;
	}

	private static String downloadSite(final String site) {
		try {
			logger.debug("Downloading {}", site);
			final String res = IOUtils.toString(new URL("http://" + site).openStream(), "UTF-8");
			logger.debug("Done {}", site);
			return res;
		} catch (final IOException e) {
			throw Throwables.propagate(e);
		}
	}

	public static void main(final String[] args) {
		final List<String> topSites = Lists.newArrayList("www.google.com", "www.youtube.com", "www.yahoo.com",
				"www.msn.com");

		final List<CompletableFuture<Double>> relevanceFutures = topSites.stream()
				.map(site -> CompletableFuture.supplyAsync(() -> downloadSite(site), this.executor))
				.map(contentFuture -> contentFuture.thenApply(this::parse))
				.map(docFuture -> docFuture.thenCompose(this::calculateRelevance))
				.collect(Collectors.<CompletableFuture<Double>> toList());
	}

	private static Document parse(final String xml) {
		return null;
	}

}
