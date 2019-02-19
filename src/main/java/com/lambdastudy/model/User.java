package com.lambdastudy.model;

public class User {

	private String name;
	private int score;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isModerator() {
		return moderator;
	}

	public void setModerator(boolean moderator) {
		this.moderator = moderator;
	}

}
