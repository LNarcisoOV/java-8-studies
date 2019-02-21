package com.lambdastudy.chapter;

import java.util.List;
import java.util.function.Consumer;

import com.lambdastudy.model.User;
import com.lambdastudy.util.UserShower;

class Chapter2 {
	public static void main(String args[]) {

		List<User> usersList = User.createUsersList();
		
		Consumer<User> shower = u -> System.out.println(u.getName());		
		
		usersList.forEach(new UserShower());
		usersList.forEach(shower);
		usersList.forEach(u -> System.out.println(u.getName() + " - " + u.isModerator()));
	}
}
