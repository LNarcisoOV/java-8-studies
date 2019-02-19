package com.lambdastudy.util;

import java.util.function.Consumer;

import com.lambdastudy.model.User;

public class UserShower implements Consumer<User> {

	public void accept(User t) {
		System.out.println(t.getName() + " - " + t.getScore());
	}

}
