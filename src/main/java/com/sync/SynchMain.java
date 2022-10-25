package com.sync;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchMain {

	private static List<Double> LIST = new ArrayList<Double>();

	public static void main(String[] args) throws InterruptedException {
		LIST = Collections.synchronizedList(LIST);
		
		MyRunnable myRunnable = new MyRunnable();
		Thread t0 = new Thread(myRunnable);
		Thread t1 = new Thread(myRunnable);
		Thread t2 = new Thread(myRunnable);
		t0.start();
		t1.start();
		t2.start();
		Thread.sleep(500);
		System.out.println(LIST);
	}

	private static class MyRunnable implements Runnable {

		@Override
		public void run() {
			LIST.add(Math.random());
			String threadName = Thread.currentThread().getName();
			System.out.println("Thread " + threadName + " inseriu na lista.");
		}

	}

}
