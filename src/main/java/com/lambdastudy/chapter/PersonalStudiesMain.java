package com.lambdastudy.chapter;

import java.util.Arrays;
import java.util.List;

public class PersonalStudiesMain {

	private static final int SKIP_ITEMS_VALUE = 2;
	private static final int LIMIT_ITEMS_VALUE = 4;
	private static final List<Integer> INT_LIST = Arrays.asList(1,2,3,4,5,5,5,6,7,7,7,7,8,8,9,9);
	
	public static void main(String[] args) {
		headerText();
		
		System.out.println();
		System.out.println("Full int list: ");
		INT_LIST.stream().forEach(System.out::print);
		
		skipExample();
		limitExample();
		distinctExample();
		filterExample();
	}
	

	private static void filterExample() {
		spaceBreaker();
		System.out.println("FILTER(e)");
		System.out.println();
		System.out.println("Int list using filter() method to avoid odd numbers:");
		INT_LIST.stream().filter(e -> e % 2 == 0).forEach(System.out::print);
	}


	private static void skipExample() {
		spaceBreaker();
		System.out.println("SKIP()");
		System.out.println();
		System.out.println("Int list using skip() method to skip the first " + SKIP_ITEMS_VALUE + " of the list:");
		INT_LIST.stream().skip(SKIP_ITEMS_VALUE).forEach(System.out::print);
	}
	
	private static void limitExample() {
		spaceBreaker();
		System.out.println("LIMIT()");
		System.out.println();
		System.out.println("Int list using limit() method to get the first " + LIMIT_ITEMS_VALUE + " of the list:");
		INT_LIST.stream().limit(LIMIT_ITEMS_VALUE).forEach(System.out::print);
	}
	
	private static void distinctExample() {
		spaceBreaker();
		System.out.println("DISTINCT()");
		System.out.println();
		System.out.println("distinct() method uses equals() and hashCode() methods.");
		System.out.println("Int list using distinct() to avoid repeated values:");
		INT_LIST.stream().distinct().forEach(System.out::print);
	}
	
	private static void headerText() {
		System.out.println("PERSONAL LAMBDA STUDIES");
		System.out.println();
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("INTERMEDIARY OPERATIONS.");
		System.out.println("---------------------------------");
		System.out.println();
		System.out.println();
		System.out.println("---------------------------------");
	}
	
	private static void spaceBreaker() {
		System.out.println();
		System.out.println();
		System.out.println("---------------------------------");
	}

}
