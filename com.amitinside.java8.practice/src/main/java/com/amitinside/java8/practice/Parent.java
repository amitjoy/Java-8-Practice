package com.amitinside.java8.practice;

import com.amitinside.java8.practice.model.IParent;

public class Parent implements IParent {

	@Override
	public String getLastMessage() {
		return null;
	}

	@Override
	public void message(final String body) {
		System.out.println(body);
	}

}
