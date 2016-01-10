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
package com.amitinside.java8.practice.dsl2;

import java.util.function.Consumer;

//Populates the Graph model.
public class GraphBuilder {

	public static Graph Graph(final Consumer<GraphBuilder> gConsumer) {
		final GraphBuilder gBuilder = new GraphBuilder();
		gConsumer.accept(gBuilder);
		return gBuilder.g;
	}

	Graph g;

	public GraphBuilder() {
		this.g = new Graph();
	}

	public void edge(final Consumer<EdgeBuilder> eConsumer) {
		final EdgeBuilder eBuilder = new EdgeBuilder();
		eConsumer.accept(eBuilder);
		final Edge e = eBuilder.edge();
		this.g.addEdge(e);
		this.g.addVertice(e.getFromVertex());
		this.g.addVertice(e.getToVertex());
	}
}