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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Graph {

	public static void printGraph(final Graph g) {
		System.out.println("Vertices...");
		for (final Vertex v : g.getVertices()) {
			System.out.print(v.getLabel() + " ");
		}
		System.out.println("");
		System.out.println("Edges...");
		for (final Edge e : g.getEdges()) {
			System.out.println(e);
		}
	}

	private final List<Edge> edges;

	private final Set<Vertex> vertices;

	public Graph() {
		this.edges = new ArrayList<>();
		this.vertices = new TreeSet<>();
	}

	public void addEdge(final Edge edge) {
		this.getEdges().add(edge);
	}

	public void addVertice(final Vertex v) {
		this.getVertices().add(v);
	}

	public List<Edge> getEdges() {
		return this.edges;
	}

	public Set<Vertex> getVertices() {
		return this.vertices;
	}
}