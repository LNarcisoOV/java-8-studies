package com.lambdastudy.chapter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.lambdastudy.inferface.Greeting;
import com.lambdastudy.inferface.PersonalConsumerInterface;
import com.lambdastudy.inferface.PersonalFunctionInterface;
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
		System.out.println("PERSONAL CONSUMER FUNCTIONAL INTERFACE: ");
		
		PersonalConsumerInterface<BigDecimal, BigDecimal> personalConsumerInterface = (value1, value2) -> System.out.println(value1.multiply(value2));
		
		List<BigDecimal> bigList = Arrays.asList(new BigDecimal(1.0), new BigDecimal(2.0), new BigDecimal(2.5));
		bigList.forEach(value -> personalConsumerInterface.perform(value, new BigDecimal(10)));
		
		System.out.println("-------------------------");
		System.out.println("PERSONAL FUNCTION INTERFACE: ");
		
		PersonalFunctionInterface<Integer, String> personalFunctionInterface = value1 -> new StringBuilder(value1 + " + ").toString(); 
		
		String result = intList.stream().map(value -> personalFunctionInterface.apply(value)).collect(Collectors.joining());
		
		System.out.println(result);
		System.out.println("-------------------------");
		
	}
}
