package com.lambdastudy.inferface;

@FunctionalInterface	
public interface PersonalConsumerInterface<T1, T2> {

	void perform(T1 t1, T2 t2);
}
