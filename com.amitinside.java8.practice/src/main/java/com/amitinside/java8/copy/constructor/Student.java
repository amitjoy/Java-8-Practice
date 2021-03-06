package com.amitinside.java8.copy.constructor;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;

public final class Student {

	private final String name;

	private final Result result;

	public Student(final String name, final Result result) {
		checkNotNull(name);
		checkNotNull(result);

		this.name = name;
		this.result = result;
	}

	public Student(final Student student) {
		this.name = student.getName();
		final Result _result = student.getResult();
		if (_result instanceof ExcellentResult) {
			this.result = new ExcellentResult((ExcellentResult) _result);
		} else {
			this.result = new Result(_result);
		}
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
