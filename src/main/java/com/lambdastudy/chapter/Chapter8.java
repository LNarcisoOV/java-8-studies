package com.lambdastudy.chapter;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.lambdastudy.model.Fibonacci;
import com.lambdastudy.model.Group;
import com.lambdastudy.model.User;

class Chapter8 {
	public static void main(String args[]) {
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
		System.out.println();
		example13();
		System.out.println();
		example14();
		System.out.println();
		example15();
		System.out.println();
		example16Fibonacci();
		System.out.println();
		example17Fibonacci();
		System.out.println();
		example18Fibonacci();
		System.out.println();
		example19Fibonacci();
		System.out.println();
		example20Fibonacci();
		System.out.println();
		example21Files();
		System.out.println();
		example22Files();
		System.out.println();
		example23Files();
		System.out.println();
		example24Files();
		System.out.println();
		example25Files();
	}

	private static void example1() {
		List<User> usersList = User.createUsersList();
		List<User> sortedUsersList = usersList.stream().filter(u -> u.getScore() > 130)
				.sorted(Comparator.comparing(User::getName)).collect(Collectors.toList());
		System.out.println("Sorting a users list by name with score more than 130 in example1:");
		sortedUsersList.forEach(System.out::println);
	}

	private static void example2() {
		List<User> usersList = User.createUsersListWithRepeatedValues();
		List<User> sortedUsersListWithDistinct = usersList.stream().filter(u -> u.getScore() > 140)
				.sorted(Comparator.comparing(User::getName)).distinct().collect(Collectors.toList());
		System.out.println("Sorting a users list by name with score more than 140 WITH DISTINCT in example2:");
		sortedUsersListWithDistinct.forEach(System.out::println);
	}

	private static void example3() {
		List<User> usersList = User.createUsersList();
		System.out.println("Getting randomly user with PEEK and FINDANY \nwith more than 120 score in example3: ");
		usersList.stream().filter(u -> u.getScore() > 120).peek(System.out::println).findAny().get();
	}

	private static void example4() {
		List<User> usersList = User.createUsersList();
		User user = usersList.stream().max(Comparator.comparingInt(User::getScore)).get();
		System.out.println("Getting the user with max score in example4: \n" + user);
	}

	private static void example5() {
		List<User> usersList = User.createUsersList();
		double sum = usersList.stream().mapToInt(User::getScore).sum();
		System.out.println("Summing all scores in example5: " + sum);
	}

	private static void example6() {
		List<User> usersList = User.createUsersList();
		int sum = usersList.stream().mapToInt(User::getScore).reduce(0, (a, b) -> a + b);
		System.out.println("Summing all scores in example6: " + sum);
	}

	private static void example7() {
		List<User> usersList = User.createUsersList();
		int sum = usersList.stream().mapToInt(User::getScore).reduce(0, Integer::sum);
		System.out.println("Summing all scores in example7: " + sum);
	}

	private static void example8() {
		List<User> usersList = User.createUsersList();
		int sum = usersList.stream().reduce(0, (a, b) -> a + b.getScore(), Integer::sum);
		System.out.println("Summing all scores without MAP function in example8: " + sum);
	}

	private static void example9() {
		List<User> usersList = User.createUsersList();
		int multiplication = usersList.stream().mapToInt(User::getScore).reduce(1, (a, b) -> a * b);
		System.out.println("Multiplying all scores in example9: " + multiplication);
	}

	private static void example10() {
		List<User> usersList = User.createUsersList();
		System.out.println("Filtering users with score bigger than 140 example10:");
		usersList.stream().filter(u -> u.getScore() > 140).peek(System.out::println).collect(Collectors.toList());
	}

	private static void example11() {
		List<User> usersList = User.createUsersList();
		System.out.println("Showing all users with stream iterator in example11:");
		usersList.iterator().forEachRemaining(System.out::println);
	}

	private static void example12() {
		List<User> usersList = User.createUsersListWithOneModerator();
		boolean anyUserModerator = usersList.stream().anyMatch(User::isModerator);
		System.out.println("Showing if exists any user with moderator's role in example12: " + anyUserModerator);
	}

	private static void example13() {
		Random random = new Random(0);
		System.out.println("Showing a random list of positive integers limited to ten in example13: ");
		Stream.generate(() -> random.nextInt()).filter(u -> u > 0).limit(10).forEach(System.out::println);
	}

	private static void example14() {
		Random random = new Random(0);
		IntStream stream = IntStream.generate(() -> random.nextInt()).filter(r -> r > 0).limit(10);
		System.out.println("Summing 10 aleatories numbers with IntStream in example 14: " + stream.sum());
	}

	private static void example15() {
		Random random = new Random(0);
		List<Integer> intList = IntStream.generate(() -> random.nextInt()).limit(10).boxed()
				.collect(Collectors.toList());
		System.out.println("Showing a random list of integers with BOXED function, limited to ten in example15:");
		intList.forEach(System.out::println);
	}

	private static void example16Fibonacci() {
		System.out.println("Fibonacci example with IntSupplier functional interface in example 16: ");
		IntStream.generate(new Fibonacci()).limit(15).forEach(System.out::println);
	}

	private static void example17Fibonacci() {
		int firstBiggerThanOneHundred = IntStream.generate(new Fibonacci()).filter(f -> f > 100).limit(100).findFirst()
				.getAsInt();
		System.out.println(
				"Getting first number bigger than 100 with Fibonacci example using an IntSupplier functional interface in example 17: \n"
						+ firstBiggerThanOneHundred);
	}

	private static void example18Fibonacci() {
		System.out.print(
				"Getting 10 first even numbers with Fibonacci example using the IntSupplier functional interface in example 18: \n");
		IntStream.generate(new Fibonacci()).filter(f -> f % 2 == 0).limit(10).forEach(System.out::println);
	}

	private static void example19Fibonacci() {
		System.out.print(
				"Getting 10 first prime numbers with Fibonacci example using the IntSupplier functional interface in example 19: \n");
		IntStream.generate(new Fibonacci()).filter(f -> f % 3 == 0).limit(10).forEach(System.out::println);
	}

	private static void example20Fibonacci() {
		System.out.print("Using Iterate of IntStream in example 20: \n");
		IntStream.iterate(0, x -> x + 1).limit(20).forEach(System.out::println);
	}

	private static void example21Files() {
		System.out.print("Listing all files inside model package in example 21: \n");
		try {
			Files.list(Paths
					.get("D:\\Users\\leonardo.vale\\Documents\\PROJECTS\\LambdaStudy\\src\\main\\java\\com\\lambdastudy\\model"))
					.forEach(System.out::println);
		} catch (IOException e) {
			System.out.print(e.getMessage() + "\n");
			e.printStackTrace();
		}
	}

	private static void example22Files() {
		System.out.print("Listing all txt files inside config package in example 22: \n");
		try {
			Files.list(Paths
					.get("D:\\Users\\leonardo.vale\\Documents\\PROJECTS\\LambdaStudy\\src\\main\\java\\com\\lambdastudy\\config"))
					.filter(f -> f.toString().endsWith(".txt")).forEach(System.out::println);
		} catch (IOException e) {
			System.out.print(e.getMessage() + "\n");
			e.printStackTrace();
		}
	}

	private static void example23Files() {
		System.out.print("Listing files and directories inside of the root folder of the project in example 23: \n");
		try {
			Files.list(Paths.get("D:\\Users\\leonardo.vale\\Documents\\PROJECTS\\LambdaStudy"))
					.forEach(System.out::println);
		} catch (IOException e) {
			System.out.print(e.getMessage() + "\n");
			e.printStackTrace();
		}
	}

	private static void example24Files() {
		System.out.print("Listing all lines of .java files in model's package in example 24: \n");
		try {
			Files.list(Paths
					.get("D:\\Users\\leonardo.vale\\Documents\\PROJECTS\\LambdaStudy\\src\\main\\java\\com\\lambdastudy\\model"))
					.filter(f -> f.toString().endsWith(".java"))
					.flatMap(f -> lines(f))
					.forEach(System.out::println);
		} catch (IOException e) {
			System.out.print(e.getMessage() + "\n");
			e.printStackTrace();
		}
	}
	
	private static void example25Files() {
		Group englishSpeakers = new Group();
		Group spanishSpeakers = new Group();
		List<User> usersList = User.createUsersList();
		
		englishSpeakers.add(usersList.get(0));
		englishSpeakers.add(usersList.get(1));
		
		spanishSpeakers.add(usersList.get(1));
		spanishSpeakers.add(usersList.get(2));
		
		List<Group> speakersGroupList = Arrays.asList(englishSpeakers, spanishSpeakers);
		
		System.out.print("Distinct list of users with FLAT MAP in example 25: \n");
		
		speakersGroupList.stream()
		.flatMap(g -> g.getUsers().stream())
		.distinct()
		.forEach(System.out::println);
	}

	private static Stream<String> lines(Path p) {
		try {
			return Files.lines(p);
		} catch (IOException e) {
			System.out.print(e.getMessage() + "\n");
			e.printStackTrace();
			throw new UncheckedIOException(e);
		}
	}
}
