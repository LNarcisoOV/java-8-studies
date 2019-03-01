package com.lambdastudy.model;

import java.util.function.IntSupplier;

public class Fibonacci implements IntSupplier {
	
	private int previous = 0;
	private int next = 1;

	public int getAsInt(){
		int returnValue = previous;
		next = next + previous;
		previous = next - previous;
		return returnValue;
	}
}
