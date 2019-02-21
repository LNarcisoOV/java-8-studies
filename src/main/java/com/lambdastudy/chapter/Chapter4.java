package com.lambdastudy.chapter;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.lambdastudy.model.User;

class Chapter4 {
	public static void main	(String[] args){
		example1();
		example2();
		example3();
	}

	private static void example1() {
		List<User> usersList = User.createUsersList();
		Consumer<User> showMessage = u -> System.out.println("Print before names...");		
		Consumer<User> showName = u -> System.out.println(u.getName());		
		
		usersList.forEach(showMessage.andThen(showName));
	}

	private static void example2() {
		List<User> usersList = User.createUsersList();
		
		Predicate<User> predicate =  u -> u.getScore() < 140 ;
		usersList.removeIf(predicate);
		
		System.out.println("Users with score bigger than 140:");
		usersList.forEach(u -> System.out.println(u.getName()));
	}

	private static void example3() {
		List<User> usersList = User.createUsersList();
		
		usersList.removeIf(u -> u.getScore() > 140 );
		
		System.out.println("Users with score smaller than 140:");
		usersList.forEach(u -> System.out.println(u.getName()));
	}
}
