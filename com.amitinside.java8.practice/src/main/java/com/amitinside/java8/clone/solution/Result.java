package com.amitinside.java8.clone.solution;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;

public class Result implements Cloneable {

	private static int _id;
	private int id;
	private final int marks;

	{
		synchronized (this.getClass()) {
			this.id = _id++;
		}
	}

	public Result(final int marks) {
		this.marks = marks;
	}

	protected Result(final Result result) {
		checkNotNull(result);

		this.marks = result.getMarks();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Result(this);
	}

	public int getMarks() {
		return this.marks;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this.getClass()).add("marks", this.marks).add("id", this.id).toString();
	}

}
