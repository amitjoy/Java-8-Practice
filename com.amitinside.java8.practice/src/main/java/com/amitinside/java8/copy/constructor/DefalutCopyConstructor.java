package com.amitinside.java8.copy.constructor;

public final class DefalutCopyConstructor {

	public static void main(final String[] args) {
		final Result result1 = new Result(50);
		final Student student1 = new Student("Sam", result1);

		final Student student2 = new Student(student1);

		System.out.println(student1);
		System.out.println(student2);
	}

}
