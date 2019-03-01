package com.lambdastudy.chapter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.lambdastudy.model.User;

class Chapter7 {
	public static void main(String[] args) {
		example1();
		System.out.println();
		example2();
		System.out.println();
		example3();
		System.out.println();
		example4();
		System.out.println();
		example5();
		System.out.println();
		example6();
		System.out.println();
		example7();
		System.out.println();
		example8();
		System.out.println();
		example9();
		System.out.println();
		example10();
		System.out.println();
		example11();
		System.out.println();
		example12();
	}

	private static void example1() {
		List<User> usersList = User.createUsersList();
		usersList.sort(Comparator.comparingInt(User::getScore).reversed());
		System.out.println("Ordering users list by reversed score in example1:");
		usersList.subList(0, usersList.size()).forEach(u -> System.out.println(u.toString()));
	}

	private static void example2() {
		List<User> usersList = User.createUsersList();
		Stream<User> stream = usersList.stream().filter(u -> u.getScore() > 130);
		System.out.println("Showing users with score bigger than 130 in example2:");
		stream.forEach(System.out::println);
	}

	private static void example3() {
		List<User> usersList = User.createUsersList();
		System.out.println("Showing users with score bigger than 140 in example3:");
		usersList.stream().filter(u -> u.getScore() > 140).forEach(System.out::println);
	}

	private static void example4() {
		List<User> usersList = User.createUsersList();
		usersList.stream().filter(u -> u.getScore() >= 150).forEach(User::transformUserInAModerator);
		System.out.println("Transforming users with score bigger or equals than 150 in a moderator in example4:");
		usersList.forEach(System.out::println);
	}

	private static void example5() {
		List<User> usersWithMoreThan140Scores = new ArrayList<User>();
		List<User> usersList = User.createUsersList();
		usersList.stream().filter(u -> u.getScore() > 140).forEach(usersWithMoreThan140Scores::add);
		System.out.println("Adding users score bigger than 140 in a new list in example5:");
		usersWithMoreThan140Scores.forEach(System.out::println);
	}

	private static void example6() {
		List<User> usersList = User.createUsersList();
		usersList = usersList.stream().filter(u -> u.getScore() > 130).collect(ArrayList::new, ArrayList::add,
				ArrayList::addAll);
		System.out.println("Collecting users score bigger than 130 score with COLLECT in example6:");
		usersList.forEach(System.out::println);
	}

	private static void example7() {
		List<User> usersList = User.createUsersList();
		usersList = usersList.stream().filter(u -> u.getScore() > 140).collect(Collectors.toList());
		System.out.println("Collecting users score bigger than 140 score with COLLECT in example7:");
		usersList.forEach(System.out::println);
	}

	private static void example8() {
		List<User> usersList = User.createUsersList();
		List<Integer> scoresList = usersList.stream().map(User::getScore).collect(Collectors.toList());
		System.out.println("Collecting only scores with MAP FUNCTION in example8:");
		scoresList.forEach(System.out::println);
	}

	private static void example9() {
		List<User> usersList = User.createUsersList();
		Double scoreAverage = usersList.stream().mapToInt(User::getScore).average().getAsDouble();
		System.out.println("Getting the score's average in example9: " + scoreAverage);
	}

	private static void example10() {
		List<User> usersList = User.createUsersList();
		double average = usersList.stream().mapToInt(User::getScore).average().orElse(0.0);
		// Without 'orElse', can throws a Exception.
		System.out.println(
				"Getting the score's average with \n'orElse' of OptionalDouble class in example10: " + average);
	}

	private static void example11() {
		try {
			List<User> usersList = new ArrayList<User>();
			double scoreAverage = usersList.stream().mapToInt(User::getScore).average()
					.orElseThrow(IllegalStateException::new);
		} catch (IllegalStateException e) {
			System.out
					.println("Throwing a IllegalStateException with empty users list in example11: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void example12() {
		List<User> usersList = User.createUsersList();
		Optional<String> optionalUser = usersList.stream().max(Comparator.comparingInt(User::getScore))
				.map(User::getName);
		System.out.println();
		System.out.println("Showing the user with more scores in example12: " + optionalUser.get());
	}
}
