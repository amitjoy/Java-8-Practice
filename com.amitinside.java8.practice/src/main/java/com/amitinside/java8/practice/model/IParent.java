package com.amitinside.java8.practice.model;

public interface IParent {

	public String getLastMessage();

	public void message(final String body);

	public default void welcome() {
		message("Parent! Hi!");
	}

}
