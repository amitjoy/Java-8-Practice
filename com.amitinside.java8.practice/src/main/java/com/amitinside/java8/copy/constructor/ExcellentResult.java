package com.amitinside.java8.copy.constructor;

public final class ExcellentResult extends Result {

	public ExcellentResult(final ExcellentResult result) {
		super(result);
	}

	public ExcellentResult(final int marks) {
		super(marks);
	}

}
