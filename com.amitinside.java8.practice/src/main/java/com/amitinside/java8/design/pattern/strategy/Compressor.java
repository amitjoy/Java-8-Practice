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
package com.amitinside.java8.design.pattern.strategy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

public final class Compressor {

	public static void classBasedExample(final Path inFile, final File outFile) throws IOException {
		final Compressor gzipCompressor = new Compressor(new GzipCompressionStrategy());
		gzipCompressor.compress(inFile, outFile);

		final Compressor zipCompressor = new Compressor(new ZipCompressionStrategy());
		zipCompressor.compress(inFile, outFile);
	}

	public static void lambdaBasedExample(final Path inFile, final File outFile) throws IOException {
		final Compressor gzipCompressor = new Compressor(GZIPOutputStream::new);
		gzipCompressor.compress(inFile, outFile);

		final Compressor zipCompressor = new Compressor(ZipOutputStream::new);
		zipCompressor.compress(inFile, outFile);

		final Compressor zipCompressor2 = new Compressor(data -> new ZipOutputStream(data));
		zipCompressor2.compress(inFile, outFile);
	}

	private final CompressionStrategy strategy;

	public Compressor(final CompressionStrategy strategy) {
		this.strategy = strategy;
	}

	public void compress(final Path inFile, final File outFile) throws IOException {
		try (OutputStream outStream = new FileOutputStream(outFile)) {
			Files.copy(inFile, this.strategy.compress(outStream));
		}
	}

}
