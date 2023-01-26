package com.functionalInterface;

import java.util.function.Function;

public class FunctionalMain {

	public static void main(String[] args) {
		int value = incrementByMethod(0);
		System.out.println(value);
		
	    value = incrementOneByFunction.apply(0);
		System.out.println(value);
	}

	static Function<Integer, Integer> incrementOneByFunction = number -> number + 1;

	static int incrementByMethod(int number) {
		return number + 1;
	}

}
