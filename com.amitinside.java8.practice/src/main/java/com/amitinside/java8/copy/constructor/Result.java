package com.amitinside.java8.copy.constructor;

import com.google.common.base.MoreObjects;

public final class Result {

	private final int marks;

	public Result(final int marks) {
		super();
		this.marks = marks;
	}

	public Result(final Result result) {
		this.marks = result.getMarks();
	}

	public int getMarks() {
		return this.marks;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this.getClass()).add("marks", this.marks).toString();
	}

}
