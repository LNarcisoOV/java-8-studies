package com.lambdastudy.model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String name;
	private Integer score;
	private boolean moderator;
	
	public User(){}
	
	public User(String name){
		this.name = name;
	}

	public User(String name, Integer score) {
		this.score = score;
		this.name = name;
		this.moderator = false;
	}
	
	public User(String name, Integer score, boolean isModerator) {
		this.score = score;
		this.name = name;
		this.moderator = isModerator;
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
	
	public void transformUserInAModerator(){
		this.moderator = true;
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

	
	public static List<User> createUsersListWithNullValues() {
		User user1 = new User("Name of User1", 150);
		User user2 = new User("Name of User2", 120);
		User user3 = new User("Name of User3", 140);
		User user4 = new User(null, null);
		User user5 = new User(null, null);
		User user6 = new User("Name of User6", 170);

		List<User> usersList = new ArrayList<User>();
		usersList.add(user1);
		usersList.add(user2);
		usersList.add(user3);
		usersList.add(user4);
		usersList.add(user5);
		usersList.add(user6);
		return usersList;
	}
	
	public static List<User> createUsersListWithRepeatedValues() {
		User user1 = new User("Name of User1", 150);
		User user2 = new User("Name of User2", 120);
		User user3 = new User("Name of User3", 140);
		User user4 = new User("Name of User4", 170);
		
		List<User> usersList = new ArrayList<User>();
		usersList.add(user1);
		usersList.add(user2);
		usersList.add(user3);
		usersList.add(user4);
		
		usersList.add(user1);
		usersList.add(user1);
		
		return usersList;
	}
	
	public static List<User> createUsersListWithOneModerator() {
		User user1 = new User("Name of User1", 150, false);
		User user2 = new User("Name of User2", 120, false);
		User user3 = new User("Name of User3", 140, false);
		User user4 = new User("Name of User4", 170, true);

		List<User> usersList = new ArrayList<User>();
		usersList.add(user1);
		usersList.add(user2);
		usersList.add(user3);
		usersList.add(user4);
		return usersList;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (moderator ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (moderator != other.moderator)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", score=" + score + ", moderator=" + moderator + "]";
	}
}
