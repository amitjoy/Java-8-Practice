package com.amitinside.java8.practice;

import com.amitinside.java8.practice.model.IParent;

public interface Child extends IParent {
	@Override
	public default void welcome() {
		message("Child! Hi!");
	}
}
