package com.amitinside.java8.practice;

public final class OverridingParent extends Parent {

	@Override
	public void welcome() {
		this.message("Class Parent: Hi!");
	}

}
