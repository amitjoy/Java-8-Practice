package com.amitinside.java8.design.pattern.command;

import java.util.List;

import com.google.common.collect.Lists;

public class MockEditor implements Editor {

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