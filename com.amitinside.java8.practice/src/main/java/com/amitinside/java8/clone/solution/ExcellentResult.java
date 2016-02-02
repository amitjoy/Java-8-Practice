package com.amitinside.java8.clone.solution;

public final class ExcellentResult extends Result {

	protected ExcellentResult(final ExcellentResult result) {
		super(result);
	}

	public ExcellentResult(final int marks) {
		super(marks);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new ExcellentResult(this);
	}

}
