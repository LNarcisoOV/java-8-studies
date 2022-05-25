package com.lambdastudy.chapter;

import java.util.Arrays;
import java.util.List;

import com.lambdastudy.inferface.Greeting;
import com.lambdastudy.inferface.PersonalPredicateInterface;
import com.lambdastudy.inferface.SumInterface;

public class FunctionalInterfaceMain {

	public static void main(String... s) {
		Greeting greeting = () -> System.out.println("Performing with functional interface.");
		greeting.perform();

		SumInterface sum = (a, b) -> System.out.println(a + b);

		System.out.println("-------------------------");
		System.out.println("SUM FUNCTIONAL INTERFACE: ");
		sum.printSum(10, 10);
		System.out.println("-------------------------");

		System.out.println("-------------------------");
		System.out.println("PERSONAL PREDICATE FUNCTIONAL INTERFACE: ");
		System.out.println("PRINT ONLY EVEN NUMBERS: ");
		

		PersonalPredicateInterface personalPredicateInterface = (a) -> a % 2 == 0;

		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		intList.stream().filter(value -> personalPredicateInterface.checkValue(value))
				.forEach(System.out::println);
		System.out.println("-------------------------");

	}
}
