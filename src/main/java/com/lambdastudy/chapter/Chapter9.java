package com.lambdastudy.chapter;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import com.lambdastudy.model.User;

class Chapter9 {
	public static void main(String... args) {
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
	}

	private static void example1() {
		try {
			LongStream linesCount = Files
					.list(Paths
							.get("D:\\Users\\leonardo.vale\\Documents\\PROJECTS\\LambdaStudy\\src\\main\\java\\com\\lambdastudy\\model"))
					.filter(p -> p.toString().endsWith("User.java")).mapToLong(p -> lines(p).count());
			System.out.println("Counting the number of lines in 'User.java' in example1: " + linesCount.sum());
		} catch (IOException e) {
			System.out.print(e.getMessage() + "\n");
			e.printStackTrace();
		}
	}

	private static void example2() {
		try {
			List<Long> longList = Files
					.list(Paths
							.get("D:\\Users\\leonardo.vale\\Documents\\PROJECTS\\LambdaStudy\\src\\main\\java\\com\\lambdastudy\\model"))
					.filter(p -> p.toString().endsWith(".java")).map(p -> lines(p).count())
					.collect(Collectors.toList());
			System.out.println("Getting the number of lines of each '.java' file in example2: ");
			longList.forEach(System.out::println);
		} catch (IOException e) {
			System.out.print(e.getMessage() + "\n");
			e.printStackTrace();
		}
	}

	private static void example3() {
		Map<Path, Long> filesAndLines = new HashMap<>();
		try {
			Files.list(Paths
					.get("D:\\Users\\leonardo.vale\\Documents\\PROJECTS\\LambdaStudy\\src\\main\\java\\com\\lambdastudy\\model"))
					.filter(p -> p.toString().endsWith(".java")).forEach(p -> filesAndLines.put(p, lines(p).count()));
			System.out.println("Getting the name and the number of lines of each '.java' file in example3: ");
			System.out.println(filesAndLines);
		} catch (IOException e) {
			System.out.print(e.getMessage() + "\n");
			e.printStackTrace();
		}
	}

	private static void example4() {
		try {
			Map<Object, Long> filesAndLines = Files
					.list(Paths
							.get("D:\\Users\\leonardo.vale\\Documents\\PROJECTS\\LambdaStudy\\src\\main\\java\\com\\lambdastudy\\model"))
					.filter(p -> p.toString().endsWith(".java"))
					.collect(Collectors.toMap(p -> p, p -> lines(p).count()));
			System.out.println("Getting the name and the number of lines of each '.java' file \n"
					+ "with Collectors.toMap() in example4: ");
			System.out.println(filesAndLines);
		} catch (IOException e) {
			System.out.print(e.getMessage() + "\n");
			e.printStackTrace();
		}
	}

	private static void example5() {
		Map<String, User> usersMap = User.createUsersList().stream()
				.collect(Collectors.toMap(User::getName, Function.identity()));
		System.out.println("Getting the name and identity of Users in example5: ");
		System.out.println(usersMap);
	}

	private static void example6() {
		List<User> usersList = User.createUsersList();

		Map<Integer, List<User>> groupedUsers = new HashMap<>();

		for (User u : usersList) {
			groupedUsers.computeIfAbsent(u.getScore(), user -> new ArrayList<User>()).add(u);
		}

		System.out.println("Grouping users with COMPUTE IF ABSENT of Map<> in example6: ");
		System.out.println(groupedUsers);
	}

	private static void example7() {
		List<User> usersList = User.createUsersListWithThreeModerators();
		Map<Integer, List<User>> groupedUsers = usersList.stream().filter(p -> p.isModerator())
				.collect(Collectors.groupingBy(User::getScore));
		System.out.println("Grouping moderators users with Collectors.groupingBy in example7: ");
		System.out.println(groupedUsers);
	}

	private static void example8() {
		List<User> usersList = User.createUsersListWithThreeModerators();
		Map<Boolean, List<User>> groupedUsers = usersList.stream()
				.collect(Collectors.partitioningBy(User::isModerator));
		System.out.println("Partitioning users with Collectors.partitioningBy by isModerator() in example8: ");
		System.out.println(groupedUsers);
	}

	private static void example9() {
		List<User> usersList = User.createUsersListWithThreeModerators();
		Map<Boolean, Integer> groupedUsers = usersList.stream()
				.collect(Collectors.partitioningBy(User::isModerator, Collectors.summingInt(User::getScore)));
		System.out.println(
				"Partitioning and summing all users with partitioningBy and summingInt and grouping by isModerator in example9: ");
		System.out.println(groupedUsers);
	}

	private static void example10() {
		String names = User.createUsersListWithThreeModerators().stream().map(User::getName)
				.collect(Collectors.joining(", "));
		System.out.println("All users names with Collectors.joining in example10: \n" + names);
	}

	private static void example11() {
		List<User> sortedUsersList = 
				User.createUsersList().stream()
				.filter(p -> p.getScore() > 130)
				.sorted(Comparator.comparing(User::getName))
				.collect(Collectors.toList());
		System.out.println("All users with score more then 130 sorted by name in example11: " );
		sortedUsersList.forEach(System.out::println);
	}

	private static void example12() {
		List<User> sortedUsersList = 
				User.createUsersList().parallelStream()
				.filter(p -> p.getScore() > 110)
				.sorted(Comparator.comparing(User::getName))
				.collect(Collectors.toList());
		System.out.println("All users with score more then 110 sorted by name with parallelStream in example12: " );
		sortedUsersList.forEach(System.out::println);
	}

	private static void example13() {

	}

	private static void example14() {

	}

	private static void example15() {

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
