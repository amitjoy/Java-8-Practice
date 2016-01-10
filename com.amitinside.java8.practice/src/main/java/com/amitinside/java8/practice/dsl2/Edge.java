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

public class Edge {
	private Vertex fromVertex;
	private Vertex toVertex;
	private Double weight;

	public Edge() {
	}

	public Edge(final Vertex fromVertex, final Vertex toVertex, final Double weight) {
		this.fromVertex = fromVertex;
		this.toVertex = toVertex;
		this.weight = weight;
	}

	public Vertex getFromVertex() {
		return this.fromVertex;
	}

	public Vertex getToVertex() {
		return this.toVertex;
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setFromVertex(final Vertex fromVertex) {
		this.fromVertex = fromVertex;
	}

	public void setToVertex(final Vertex toVertex) {
		this.toVertex = toVertex;
	}

	public void setWeight(final Double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return this.fromVertex.getLabel() + " to " + this.toVertex.getLabel() + " with weight " + this.getWeight();
	}
}