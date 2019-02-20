package com.lambdastudy.chapter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.lambdastudy.model.User;

class Chapter4 {
	public static void main	(String[] args){
		User user1 = new User("Name of User1", 150);
		User user2 = new User("Name of User2", 120);
		User user3 = new User("Name of User3", 140);
		User user4 = new User("Name of User4", 170);

		List<User> usersList = new ArrayList<User>();
		usersList.add(user1);
		usersList.add(user2);
		usersList.add(user3);
		usersList.add(user4);
		
		example1(usersList);
		example2();
		example3();
	}

	private static void example1(List<User> usersList) {
		Consumer<User> showMessage = u -> System.out.println("Print before names...");		
		Consumer<User> showName = u -> System.out.println(u.getName());		
		
		usersList.forEach(showMessage.andThen(showName));
	}

	private static void example2() {
		User user1 = new User("Name of User1", 150);
		User user2 = new User("Name of User2", 120);
		User user3 = new User("Name of User3", 140);
		User user4 = new User("Name of User4", 170);

		List<User> usersList = new ArrayList<User>();
		usersList.add(user1);
		usersList.add(user2);
		usersList.add(user3);
		usersList.add(user4);
		
		Predicate<User> predicate =  u -> u.getScore() < 140 ;
		usersList.removeIf(predicate);
		
		System.out.println("Users with score bigger than 140:");
		usersList.forEach(u -> System.out.println(u.getName()));
	}

	private static void example3() {
		User user1 = new User("Name of User1", 150);
		User user2 = new User("Name of User2", 120);
		User user3 = new User("Name of User3", 140);
		User user4 = new User("Name of User4", 170);

		List<User> usersList = new ArrayList<User>();
		usersList.add(user1);
		usersList.add(user2);
		usersList.add(user3);
		usersList.add(user4);
		
		usersList.removeIf(u -> u.getScore() > 140 );
		
		System.out.println("Users with score smaller than 140:");
		usersList.forEach(u -> System.out.println(u.getName()));
		
	}
}
