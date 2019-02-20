package com.lambdastudy.chapter;

import java.awt.Button;

import com.lambdastudy.impl.Validator;

class Chapter3 {
	public static void main(String... args) {
		example1();
		example2();
		example3();
		example4();
		example5();
		example6();
	}

	private static void example1() {
		Runnable r = () -> {
			for (int i = 0; i <= 100; i++) {
				System.out.println(i);
			}
		};

		new Thread(r).start();
	}

	private static void example2() {
		new Thread(() -> {
			for (int i = 0; i <= 100; i++) {
				System.out.println(i);
			}
		}).start();
	}

	private static void example3() {
		Button button = new Button();
		button.addActionListener(event -> System.out.println("Added a click event."));
	}

	private static void example4() {
		Validator<String> validator = value -> value.matches("[0-9]{5}-[0-9]{3}");
		Boolean isAValidCep = validator.validate("60325-220");
		System.out.println("Is a valid cep? " + isAValidCep);

		Validator<Integer> validator2 = value -> 1 > 0;
		boolean isBigger = validator2.validate(1);
		System.out.println("1 > 0? " + isBigger);
	}

	private static void example5() {
		Runnable r = () -> System.out.println("What am I? A Lambda?");
		System.out.println(r);
		System.out.println(r.getClass());
	}

	private static void example6() {
		final int number = 5;
		new Thread(() -> System.out.println(number)).start();
	}
}
