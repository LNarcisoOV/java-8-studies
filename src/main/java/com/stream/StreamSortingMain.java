package com.stream;

import java.util.Arrays;
import java.util.Comparator;

public class StreamSortingMain {

    public static void main(String... a) {
        System.out.println("Sorting string list asc: ");
        Arrays.asList("g", "c", "b", "", "a", "z").stream().sorted().forEach(System.out::println);
        
        System.out.println();

        System.out.println("Sorting string list desc: ");
        Arrays.asList("g", "c", "b", "", "a", "z").stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
