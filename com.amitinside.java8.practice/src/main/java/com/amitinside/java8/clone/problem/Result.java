package com.amitinside.java8.clone.problem;

import com.google.common.base.MoreObjects;

public class Result implements Cloneable {

	private static int _id;
	private int id;
	private int marks;

	{
		synchronized (this.getClass()) {
			this.id = _id++;
		}
	}

	public Result(final int marks) {
		this.marks = marks;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		final Result result = (Result) super.clone();
		result.marks = this.marks;
		result.id = _id++;
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
