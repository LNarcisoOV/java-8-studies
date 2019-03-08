package com.lambdastudy.chapter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

class Chapter10 {
	public static void main(String args[]) {
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
		LocalDate nextMonth = LocalDate.now().plusMonths(1);
		System.out.println("Getting the same date but with the next month in example1: \n" + nextMonth);
	}

	private static void example2() {
		LocalDateTime dateWithHour = LocalDateTime.now();
		System.out.println("Getting the date with hour in example2: \n" + dateWithHour);
	}

	private static void example3() {
		LocalTime hour = LocalTime.now();
		System.out.println("Getting the hour in example3: \n" + hour);
	}

	private static void example4() {
		LocalDateTime localDaAtNoon = LocalDate.now().atTime(12, 0);
		System.out.println("Geting current date at noon in example4: \n" + localDaAtNoon);
	}

	private static void example5() {
		LocalTime now = LocalTime.now();
		LocalDate today = LocalDate.now();
		LocalDateTime todayWithHour = today.atTime(now);
		System.out.println("Getting the date with hour in example5: \n" + todayWithHour);
	}

	private static void example6() {
		LocalDateTime today = LocalDateTime.now();
		ZonedDateTime zoned = today.atZone(ZoneId.of("America/Sao_Paulo"));
		System.out.println("Getting the date with ZonedDateTime in example6: \n" + zoned);
	}

	private static void example7() {
		ZonedDateTime zoned = ZonedDateTime.now();
		LocalDateTime local = zoned.toLocalDateTime();
		System.out.println("Converting ZonedDateTime in LocalDateTime in example7: \n" + local);
	}

	private static void example8() {
		LocalDate localDate = LocalDate.of(1988, 6, 25);
		LocalDateTime localDateTime = LocalDateTime.of(2011, 12, 28, 23, 0);
		System.out.println("Setting LocalDate.of in example8: \n" + localDate);
		System.out.println("Setting LocalDateTime.of in example8: \n" + localDateTime);
	}

	private static void example9() {
		LocalDate today = LocalDate.now();
		LocalDate todayPlusOne = LocalDate.now().plusDays(1);
		System.out.println("Comparing dates in example9: \n");
		System.out.println("Today.isBefore(todayPlusOne): " + today.isBefore(todayPlusOne));
		System.out.println("Today.isEqual(todayPlusOne): " + today.isEqual(todayPlusOne));
		System.out.println("Today.isAfter(todayPlusOne): " + today.isAfter(todayPlusOne));
	}

	private static void example10() {
		ZonedDateTime tokyo = ZonedDateTime.of(2011, 5, 2, 10, 30, 0, 0, ZoneId.of("Asia/Tokyo"));
		ZonedDateTime saoPaulo = ZonedDateTime.of(2011, 5, 2, 10, 30, 0, 0, ZoneId.of("America/Sao_Paulo"));
		System.out.println("Comparing dates with timezone in example10: \n");
		System.out.println("tokyo.isBefore(saoPaulo): " + tokyo.isBefore(saoPaulo));
		System.out.println("tokyo.isEqual(saoPaulo): " + tokyo.isEqual(saoPaulo));
		System.out.println("tokyo.isAfter(saoPaulo): " + tokyo.isAfter(saoPaulo));
	}

	private static void example11() {
		ZonedDateTime tokyo = ZonedDateTime.of(2011, 5, 2, 10, 30, 0, 0, ZoneId.of("Asia/Tokyo"));
		ZonedDateTime saoPaulo = ZonedDateTime.of(2011, 5, 2, 10, 30, 0, 0, ZoneId.of("America/Sao_Paulo"));
		tokyo = tokyo.plusHours(12);
		System.out.println("Comparing dates with timezone and adding some hours in Tokyo in example11: \n");
		System.out.println("tokyo.isBefore(saoPaulo): " + tokyo.isBefore(saoPaulo));
		System.out.println("tokyo.isEqual(saoPaulo): " + tokyo.isEqual(saoPaulo));
		System.out.println("tokyo.isAfter(saoPaulo): " + tokyo.isAfter(saoPaulo));
	}

	private static void example12() {
		System.out.println("Comparing dates with ENUMs example12:");
		System.out.println("LocalDate.of(2014, Month.DECEMBER, 25): " + LocalDate.of(2014, Month.DECEMBER, 25));
		System.out.println("Month.DECEMBER.firstMonthOfQuarter(): " + Month.DECEMBER.firstMonthOfQuarter());
		System.out.println("Month.DECEMBER.plus(2): " + Month.DECEMBER.plus(2));
		System.out.println("Month.DECEMBER.minus(1): " + Month.DECEMBER.minus(1));
	}

	private static void example13() {
		System.out.println("Showing months name with month.getDisplayName example13:");
		System.out.println("Complete name: " + Month.DECEMBER.getDisplayName(TextStyle.FULL, new Locale("pt")));
		System.out.println("Short name: " + Month.DECEMBER.getDisplayName(TextStyle.SHORT, new Locale("pt")));
	}
}
