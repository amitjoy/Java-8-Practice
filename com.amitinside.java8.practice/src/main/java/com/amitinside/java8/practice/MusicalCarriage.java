package com.amitinside.java8.practice;

public class MusicalCarriage implements IJukeBox, ICarriage {

	@Override
	public String rock() {
		return ICarriage.super.rock();
	}

}
