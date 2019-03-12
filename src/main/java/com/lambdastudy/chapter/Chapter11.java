package com.lambdastudy.chapter;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.lambdastudy.model.Customer;
import com.lambdastudy.model.Payment;
import com.lambdastudy.model.Product;
import com.lambdastudy.model.Subscription;

class Chapter11 {
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
		System.out.println("Sorting payments by date with sorted(Comparator.comparing()) in example1:");
		getAllPaymentsPopulated().stream().sorted(Comparator.comparing(Payment::getDate)).forEach(System.out::println);
	}

	private static void example2() {
		BigDecimal sum = getAllPaymentsPopulated().stream()
				.flatMap(p -> p.getProducts().stream().map(Product::getPrice)).reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println("Getting the sum of all payments with REDUCE() in example2: \n" + sum);
	}

	private static void example3() {
		Map<Product, Long> topProducts = getAllPaymentsPopulated().stream().flatMap(p -> p.getProducts().stream())
				.sorted(Comparator.comparing(Product::getPrice))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Getting top sellers products with Collectors.counting() in example3: ");
		topProducts.entrySet().forEach(System.out::println);
	}

	private static void example4() {
		Map<Product, Long> topProducts = getAllPaymentsPopulated().stream().flatMap(p -> p.getProducts().stream())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Optional<?> op = topProducts.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
		System.out.println(
				"Getting top seller product with \nmax(Comparator.comparing(Map.Entry::getValue) in example4: \n"
						+ op.get());
	}

	private static void example5() {
		Map<Product, BigDecimal> totalValuePerProduct = getAllPaymentsPopulated().stream()
				.flatMap(p -> p.getProducts().stream()).collect(Collectors.groupingBy(Function.identity(),
						Collectors.reducing(BigDecimal.ZERO, Product::getPrice, BigDecimal::add)));

		System.out.println("Getting summed value from each product in example5: ");
		totalValuePerProduct.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue))
				.forEach(System.out::println);
	}

	private static void example6() {
		Map<Customer, List<List<Product>>> customerToProductList = getAllPaymentsPopulated().stream().collect(Collectors
				.groupingBy(Payment::getCustomer, Collectors.mapping(Payment::getProducts, Collectors.toList())));

		System.out.println("Getting a Map of Customers and their respective products list in example6: ");
		customerToProductList.entrySet().stream().sorted(Comparator.comparing(e -> e.getKey().getName()))
				.forEach(System.out::println);
	}

	private static void example7() {
		Map<Customer, List<List<Product>>> customerToProductList = getAllPaymentsPopulated().stream().collect(Collectors
				.groupingBy(Payment::getCustomer, Collectors.mapping(Payment::getProducts, Collectors.toList())));

		Map<Customer, List<Product>> customerToProductList2 = customerToProductList.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey,
						e -> e.getValue().stream().flatMap(List::stream).collect(Collectors.toList())));

		System.out.println("Getting a Map of Customers and their respective products list in example7: ");
		customerToProductList2.entrySet().stream().forEach(System.out::println);
	}

	private static void example8() {
		Map<Customer, BigDecimal> especialCustomer = getAllPaymentsPopulated().stream()
				.collect(
						Collectors.groupingBy(Payment::getCustomer,
								Collectors.reducing(BigDecimal.ZERO, p -> p.getProducts().stream()
										.map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add),
										BigDecimal::add)));

		System.out.println("Getting total value paid per customer example8: ");
		especialCustomer.entrySet().stream().forEach(System.out::println);
	}

	private static void example9() {
		Function<Payment, BigDecimal> paymentToTotal = p -> p.getProducts().stream().map(Product::getPrice)
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		Map<Customer, BigDecimal> totalValuePerCustomer = getAllPaymentsPopulated().stream()
				.collect(Collectors.groupingBy(Payment::getCustomer,
						Collectors.reducing(BigDecimal.ZERO, paymentToTotal, BigDecimal::add)));

		System.out.println("Getting total value paid per customer example9: ");
		totalValuePerCustomer.entrySet().stream().forEach(System.out::println);
	}

	private static void example10() {
		Map<YearMonth, List<Payment>> paymentsPerMonth = getAllPaymentsPopulated().stream()
				.collect(Collectors.groupingBy(p -> YearMonth.from(p.getDate())));

		System.out.println("Getting payments grouped by month and year in example10: ");
		paymentsPerMonth.entrySet().stream().forEach(System.out::println);
	}

	private static void example11() {
		Map<YearMonth, BigDecimal> paymentsPerMonth = getAllPaymentsPopulated().stream()
				.collect(
						Collectors.groupingBy(p -> YearMonth.from(p.getDate()),
								Collectors.reducing(BigDecimal.ZERO, p -> p.getProducts().stream()
										.map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add),
										BigDecimal::add)));

		System.out.println("Getting the payment's sum grouped by month and year in example11: ");
		paymentsPerMonth.entrySet().stream().forEach(System.out::println);
	}

	private static void example12() {
		Subscription subscription = getAllSubscriptionsPopulated().get(0);
		long numberOfMonthsSubscripted = ChronoUnit.MONTHS.between(subscription.getBegin(),
				subscription.getEnd().orElse(LocalDateTime.now()));
		BigDecimal totalPaid = subscription.getMonthlyFee().multiply(new BigDecimal(numberOfMonthsSubscripted));

		System.out.println("Getting the interval between subscription date and end date of subscription in example12: "
				+ numberOfMonthsSubscripted);
		System.out.println("Getting the amount paid in this interval of " + numberOfMonthsSubscripted
				+ " months in example12: " + totalPaid);
	}

	private static void example13() {
		BigDecimal totalOfAllSubscriptions = getAllSubscriptionsPopulated().stream().map(Subscription::getTotalPaid)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println(
				"Getting the sum of all payments of all subscription in example13: " + totalOfAllSubscriptions);
	}

	private static List<Payment> getAllPaymentsPopulated() {
		Customer paulo = new Customer("Paulo Silveira");
		Customer rodrigo = new Customer("Rodrigo Turini");
		Customer guilherme = new Customer("Guilherme Silveira");
		Customer adriano = new Customer("Adriano Almeida");

		Product bach = new Product("Bach Completo", Paths.get("/music/bach.mp3"), new BigDecimal(100));
		Product poderosas = new Product("Dream Theater", Paths.get("/music/at_wits_end.mp3"), new BigDecimal(90));
		Product bandeira = new Product("Bandeira Brasil", Paths.get("/images/brasil.jpg"), new BigDecimal(50));
		Product beauty = new Product("Beleza Americana", Paths.get("beauty.mov"), new BigDecimal(150));
		Product vingadores = new Product("Os Vingadores", Paths.get("/movies/vingadores.mov"), new BigDecimal(200));
		Product amelie = new Product("Amelie Poulain", Paths.get("/movies/amelie.mov"), new BigDecimal(100));

		LocalDateTime today = LocalDateTime.now();
		LocalDateTime yesterday = today.minusDays(1);
		LocalDateTime lastMonth = today.minusMonths(1);
		Payment payment1 = new Payment(Arrays.asList(bach, poderosas), today, paulo);
		Payment payment2 = new Payment(Arrays.asList(bach, bandeira, amelie), yesterday, rodrigo);
		Payment payment3 = new Payment(Arrays.asList(beauty, vingadores, bach), today, adriano);
		Payment payment4 = new Payment(Arrays.asList(bach, poderosas, amelie), lastMonth, guilherme);
		Payment payment5 = new Payment(Arrays.asList(beauty, amelie), yesterday, paulo);

		return Arrays.asList(payment1, payment2, payment3, payment4, payment5);
	}

	private static List<Subscription> getAllSubscriptionsPopulated() {
		Customer paulo = new Customer("Paulo Silveira");
		Customer rodrigo = new Customer("Rodrigo Turini");
		Customer adriano = new Customer("Adriano Almeida");

		LocalDateTime today = LocalDateTime.now();
		LocalDateTime yesterday = today.minusDays(1);

		BigDecimal monthlyFee = new BigDecimal("99.90");
		Subscription s1 = new Subscription(monthlyFee, yesterday.minusMonths(5), paulo);
		Subscription s2 = new Subscription(monthlyFee, yesterday.minusMonths(8), today.minusMonths(1), rodrigo);
		Subscription s3 = new Subscription(monthlyFee, yesterday.minusMonths(5), today.minusMonths(2), adriano);
		List<Subscription> subscriptions = Arrays.asList(s1, s2, s3);
		return subscriptions;
	}
}
