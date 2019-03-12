package com.lambdastudy.chapter;

import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

import com.lambdastudy.controller.ReportsController;
import com.lambdastudy.impl.Role;
import com.lambdastudy.model.User;

class Chapter12 {
	public static void main(String... args) {
		example1();
		System.out.println();
		example2();
		System.out.println();
		example3();
		System.out.println();
		example4();
		System.out.println();
		example5();
		System.out.println();
		example6();
		System.out.println();
		example7();
		System.out.println();
		example8();
		System.out.println();
		example9();
		System.out.println();
		example10();
		System.out.println();
		example11();
		System.out.println();
		example12();
		System.out.println();
		example13();
	}

	private static void example1() {
		Supplier<String> supplier = () -> "This is a String";
		PrivilegedAction<String> privileged = () -> "This is a String";
		method((Supplier<String>) () -> "This is a String");
		method((PrivilegedAction<String>) () -> "This is a String");
	}

	private static void example2() {
		Supplier<String> supplier = () -> "Executing supplier in example2;";
		PrivilegedAction<String> privileged = () -> "Executing privilegedAction in example2;";
		execute(supplier);
		execute(privileged::run);
	}

	private static void example3() {
		Runnable r = () -> {
			System.out.println("I'm a runnable in example 3!");
		};
		new Thread(r).start();
	}

	private static void example4() {
		new Thread(() -> System.out.println("I'm a runnable in example 4!")).start();
	}

	private static void example5() {
		Callable<String> c = () -> "retorna uma String";
		PrivilegedAction<String> p = () -> "retorna uma String";
	}

	private static void example6() {
		System.out.println("Lambda with CAST in comparator in exampl6:");
		System.out.println("User.createUsersList().sort(Comparator.comparingInt(\n(User u) -> u.getScore()).thenComparing(u -> u.getName())\n);");
		User.createUsersList().sort(Comparator.comparingInt((User u) -> u.getScore()).thenComparing(u -> u.getName()));
	}

	private static void example7() {
		ReportsController rep = new ReportsController();
		Role[] annotationByType = rep.getClass().getAnnotationsByType(Role.class);
		System.out.println("Getting the value of annotations in ReportsController in example7: ");
		Arrays.asList(annotationByType).forEach(a -> System.out.println(a.value()));
	}

	private static void example8() {

	}

	private static void example9() {

	}

	private static void example10() {

	}

	private static void example11() {

	}

	private static void example12() {

	}

	private static void example13() {

	}

	private static void method(Supplier<String> s) {

	}

	private static void method(PrivilegedAction<String> p) {

	}

	private static void execute(Supplier<String> supplier) {
		System.out.println(supplier.get());
	}
}
