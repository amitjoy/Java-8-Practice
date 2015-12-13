package com.amitinside.java8.practice;

import java.util.List;

import org.jooq.lambda.Seq;

public final class SeqJoolPractice {

	public static void main(final String[] args) {
		final List<String> alphabet = Seq.rangeClosed('A', 'Z').map(Object::toString).toList();
		System.out.println(alphabet);
	}

}
