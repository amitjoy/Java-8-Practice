package com.amitinside.java8.clone;

public final class CloneMethod {

	public static void main(final String[] args) throws CloneNotSupportedException {
		final Result result1 = new Result(50);
		final Student student1 = new Student("Sam", result1);

		final Student student2 = (Student) student1.clone();
		System.out.println(student2);
	}

}
