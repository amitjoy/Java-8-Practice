package com.amitinside.java8.clone.solution;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;

public final class Student implements Cloneable {

	private final String name;

	private final Result result;

	public Student(final String name, final Result result) {
		checkNotNull(name);
		checkNotNull(result);

		this.name = name;
		this.result = result;
	}

	protected Student(final Student student) throws CloneNotSupportedException {
		this.name = student.getName();
		this.result = (Result) student.getResult().clone();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Student(this);
	}

	public String getName() {
		return this.name;
	}

	public Result getResult() {
		return this.result;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this.getClass()).add("name", this.name).add("result", this.result).toString();
	}

}
