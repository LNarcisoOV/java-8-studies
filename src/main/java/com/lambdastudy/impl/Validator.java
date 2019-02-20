package com.lambdastudy.impl;

@FunctionalInterface
public interface Validator<T> {
	boolean validate(T t);
}
