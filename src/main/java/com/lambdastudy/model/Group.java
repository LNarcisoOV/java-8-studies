package com.lambdastudy.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Group {
	private Set<User> usersSet = new HashSet<>();
	
	public void add(User user){
		usersSet.add(user);
	}
	
	public Set<User> getUsers(){
		return  Collections.unmodifiableSet(this.usersSet);
	}
}
