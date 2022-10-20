package com.lambdastudy.chapter;

import java.util.Arrays;
import java.util.List;

public class PersonalStudiesMain {

	private static final int SKIP_ITEMS_VALUE = 2;
	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		System.out.println("PERSONAL LAMBDA STUDIES");
		
		System.out.println();
		System.out.println("Full int list: ");
		intList.stream().skip(SKIP_ITEMS_VALUE).forEach(System.out::println);
		
		System.out.println();
		System.out.println("Int list using skip() method to skip the first " + SKIP_ITEMS_VALUE + " of the list:");
		intList.stream().skip(SKIP_ITEMS_VALUE).forEach(System.out::println);
	}

}
