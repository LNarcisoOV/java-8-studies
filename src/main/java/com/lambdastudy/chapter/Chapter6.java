package com.lambdastudy.chapter;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.lambdastudy.model.User;

class Chapter6 {
	public static void main(String... args) {
		example1();
		example2();
		example3();
		example4();
		example5();
		example6();
		example7();
		example8();
		example9();
	}

	private static void example1() {
		List<User> usersList = User.createUsersList();
		usersList.forEach(User::transformUserInAModerator);
	}

	private static void example2() {
		Consumer<User> consumer = User::transformUserInAModerator;
		List<User> usersList = User.createUsersList();
		usersList.forEach(consumer);
	}

	private static void example3() {
		Function<User, String> byName = User::getName;
		List<User> usersList = User.createUsersList();
		usersList.sort(Comparator.comparing(byName));
		System.out.println("Users list ordered by name in example 3: ");
		usersList.forEach(u -> System.out.println(u.getName()));
	}

	private static void example4() {
		List<User> usersList = User.createUsersList();
		usersList.add(new User("Name of User5", 90));
		usersList.sort(Comparator.comparingInt(User::getScore).thenComparing(User::getName));
		System.out.println("Users list ordered by score and name in example 4: ");
		usersList.forEach(u -> System.out.println(u.getName() + " - " + u.getScore()));
	}

	private static void example5() {
		List<User> usersList = User.createUsersList();
		usersList.sort(Comparator.comparing(User::getName).reversed());
		System.out.println("Users list reversed by name: ");
		usersList.forEach(u -> System.out.println(u.getName() != null ? u.getName() : null));
	}

	private static void example6() {
		User user = new User("Leonardo Narciso", 1);
		Runnable runnable = user::transformUserInAModerator;
		runnable.run();
		System.out.println("Runnable run() in example6 to turn user a moderator:");
		System.out.println(user.getName() + ", is a moderator? " + user.isModerator());
	}

	private static void example7() {
		List<User> usersList = User.createUsersList();
		System.out.println("Users list in example7: ");
		usersList.forEach(System.out::println);
	}

	private static void example8() {
		Supplier<User> supplier = User::new;
		User user = supplier.get();
	}

	private static void example9() {
		BiFunction<String, Integer, User> biFunc = User::new;
		User user1 = biFunc.apply("Leonardo Narciso", 1000);
		System.out.println("User with BiFunction in example9: ");
		System.out.println(user1.getName());
	}
}
