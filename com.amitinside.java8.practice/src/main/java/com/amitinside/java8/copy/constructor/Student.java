package com.amitinside.java8.copy.constructor;

import com.google.common.base.MoreObjects;

public final class Student {

	private final String name;

	private final Result result;

	public Student(final String name, final Result result) {
		super();
		this.name = name;
		this.result = result;
	}

	public Student(final Student student) {
		this.name = student.getName();
		this.result = new Result(student.getResult());
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
