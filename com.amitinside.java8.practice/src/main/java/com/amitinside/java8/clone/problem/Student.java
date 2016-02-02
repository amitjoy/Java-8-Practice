package com.amitinside.java8.clone.problem;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;

public final class Student implements Cloneable {

	private String name;

	private Result result;

	public Student(final String name, final Result result) {
		checkNotNull(name);
		checkNotNull(result);

		this.name = name;
		this.result = result;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		final Student student = (Student) super.clone();
		student.name = this.name;
		student.result = (Result) this.result.clone();
		return student;
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
