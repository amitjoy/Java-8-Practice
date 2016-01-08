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
package com.amitinside.java8.design.pattern.command;

import java.util.List;

import com.google.common.collect.Lists;

public final class MockEditor implements Editor {

	private final List<String> actions = Lists.newArrayList();

	@Override
	public void close() {
		this.actions.add("close");
	}

	@Override
	public void open() {
		this.actions.add("open");
	}

	@Override
	public void save() {
		this.actions.add("save");
	}

}