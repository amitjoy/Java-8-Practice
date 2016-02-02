package com.amitinside.java8.clone.solution;

public class MixedApproachInCloning {

	public static void main(final String[] args) throws CloneNotSupportedException {
		final Result result1 = new Result(50);
		final Student student1 = new Student("Sam", result1);
		System.out.println(student1);

		final Student student2 = (Student) student1.clone();
		System.out.println(student2);
	}

}
