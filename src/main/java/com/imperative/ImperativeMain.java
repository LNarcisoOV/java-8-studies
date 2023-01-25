package com.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ImperativeMain {

	public static void main(String... args) {
		List<Person> people = List.of(new Person("John", Gender.MALE), new Person("Doe", Gender.MALE),
				new Person("Vivian", Gender.FEMALE), new Person("Bia", Gender.FEMALE));

		List<Person> females = new ArrayList<>();

		Predicate<Person> predicateFemalePerson = person -> Gender.FEMALE.equals(person.getGender());
		
		females = people.stream().filter(predicateFemalePerson)
				.collect(Collectors.toList());

		females.forEach(System.out::println);

	}

	static class Person {
		private String name;
		private Gender gender;

		private Person(String name, Gender gender) {
			super();
			this.name = name;
			this.gender = gender;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Gender getGender() {
			return gender;
		}

		public void setGender(Gender gender) {
			this.gender = gender;
		}

		@Override
		public int hashCode() {
			return Objects.hash(gender, name);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			return gender == other.gender && Objects.equals(name, other.name);
		}

		@Override
		public String toString() {
			return "People [name=" + name + ", gender=" + gender + "]";
		}

	}

	enum Gender {
		MALE, FEMALE
	}
}
