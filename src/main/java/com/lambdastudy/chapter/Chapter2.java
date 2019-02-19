package com.lambdastudy.chapter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.lambdastudy.model.User;
import com.lambdastudy.util.UserShower;

public class Chapter2 {
	public static void main(String args[]) {
		User user1 = new User("Name of User1", 150);
		User user2 = new User("Name of User2", 120);
		User user3 = new User("Name of User3", 140);
		User user4 = new User("Name of User4", 170);

		List<User> usersList = Arrays.asList(user1, user2, user3, user4);
		
		Consumer<User> shower = u -> System.out.println(u.getName());		
		
		usersList.forEach(new UserShower());
		usersList.forEach(shower);
		usersList.forEach(u -> System.out.println(u.getName() + " - " + u.isModerator()));
	}
}
