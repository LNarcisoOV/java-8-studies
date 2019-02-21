package com.lambdastudy.model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String name;
	private Integer score;
	private boolean moderator;

	public User(String name, int score) {
		this.score = score;
		this.name = name;
		this.moderator = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public boolean isModerator() {
		return moderator;
	}

	public void setModerator(boolean moderator) {
		this.moderator = moderator;
	}

	public static List<User> createUsersList() {
		User user1 = new User("Name of User1", 150);
		User user2 = new User("Name of User2", 120);
		User user3 = new User("Name of User3", 140);
		User user4 = new User("Name of User4", 170);

		List<User> usersList = new ArrayList<User>();
		usersList.add(user1);
		usersList.add(user2);
		usersList.add(user3);
		usersList.add(user4);
		return usersList;
	}

}
