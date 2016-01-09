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
package com.amitinside.java8.design.pattern.observer;

import java.util.List;

import com.google.common.collect.Lists;

public final class Moon {

	private static void classBasedExample() {
		final Moon moon = new Moon();
		moon.startSpying(new Nasa());
		moon.startSpying(new Aliens());

		moon.land("An asteroid");
		moon.land("Apollo 11");
	}

	private static void lambdaBasedExample() {
		final Moon moon = new Moon();

		moon.startSpying(name -> {
			if (name.contains("Apollo")) {
				System.out.println("We made it!");
			}
		});

		moon.startSpying(name -> {
			if (name.contains("Apollo")) {
				System.out.println("They're distracted, lets invade earth!");
			}
		});

		moon.land("An asteroid");
		moon.land("Apollo 11");
	}

	public static void main(final String[] args) {
		classBasedExample();
		lambdaBasedExample();
	}

	private final List<LandingObserver> observers = Lists.newCopyOnWriteArrayList();

	public void land(final String name) {
		for (final LandingObserver observer : this.observers) {
			observer.observeLanding(name);
		}
	}

	public void startSpying(final LandingObserver observer) {
		this.observers.add(observer);
	}

}
