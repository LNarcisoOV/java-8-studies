package com.lambdastudy.model;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Group {
	private List<User> usersList = new ArrayList<>();
	
	public void add(User user){
		usersList.add(user);
	}
	
	public List<User> getUsers(){
		return  Collections.unmodifiableList(this.usersList);
	}
}
