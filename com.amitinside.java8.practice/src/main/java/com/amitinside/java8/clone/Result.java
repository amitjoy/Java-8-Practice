package com.amitinside.java8.clone;

import com.google.common.base.MoreObjects;

public class Result implements Cloneable {

	private int marks;

	public Result(final int marks) {
		this.marks = marks;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		final Result result = (Result) super.clone();
		result.marks = this.marks;
		return result;
	}

	public int getMarks() {
		return this.marks;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this.getClass()).add("marks", this.marks).toString();
	}

}
