package com.amitinside.java8.clone;

public final class ExcellentResult extends Result {

	public ExcellentResult(final int marks) {
		super(marks);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
