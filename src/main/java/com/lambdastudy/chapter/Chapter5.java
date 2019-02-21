package com.lambdastudy.chapter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

import com.lambdastudy.model.User;

class Chapter5 {
	public static void main(String... args) {
		example1();
		example2();
		example3();
		example4();
		example5();
		example6();
		example7();
	}

	private static void example1() {
		List<User> usersList = User.createUsersList();
		Collections.sort(usersList, (u1, u2) -> u1.getScore().compareTo(u2.getScore()));
		System.out.println("Users list ordered by score in example 1: ");
		usersList.forEach(u -> System.out.println(u.getName()));
	}

	private static void example2() {
		List<User> usersList = User.createUsersList();
		usersList.sort((u1, u2) -> u1.getName().compareTo(u2.getName()));
		System.out.println("Users list ordered by name in example 2: ");
		usersList.forEach(u -> System.out.println(u.getName()));
	}

	private static void example3() {
		List<User> usersList = User.createUsersList();
		usersList.sort(Comparator.comparing(u -> u.getName()));
		System.out.println("Users list ordered by name in example 3: ");
		usersList.forEach(u -> System.out.println(u.getName()));
	}

	private static void example4() {
		List<String> words = Arrays.asList("Code's house", "Alura", "Caelum");
		Collections.sort(words);
		System.out.println("Words list ordered in example 4: ");
		words.forEach(u -> System.out.println(u));
	}
	
	private static void example5() {
		List<String> words = Arrays.asList("Code's house", "Alura", "Caelum");
		words.sort(Comparator.naturalOrder());
		System.out.println("Words list ordered in example 4: ");
		words.forEach(u -> System.out.println(u));
	}
	
	private static void example6() {
		List<User> usersList = User.createUsersList();
		ToIntFunction<User> scores = u -> u.getScore();
		Comparator<User> comparator = Comparator.comparingInt(scores);
		usersList.sort(comparator);
		System.out.println("Users list ordered by score in example 6: ");
		usersList.forEach(u -> System.out.println(u.getName()));
	}
	
	private static void example7() {
		List<User> usersList = User.createUsersList();
		usersList.sort(Comparator.comparingInt(u -> u.getScore()));
		System.out.println("Users list ordered by score in example 7: ");
		usersList.forEach(u -> System.out.println(u.getName()));
	}

}
