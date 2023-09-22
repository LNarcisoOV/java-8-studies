package com.optional;

import java.util.Optional;

public class OptionalMain {

    public static void main(String args[]) {
        Optional<String> hello = Optional.ofNullable(null);
        
        
        String value = hello.orElseGet(() -> {
           return "World"; 
        });

        System.out.println(value);
        
        
        hello.ifPresentOrElse(System.out::println, () -> System.out.println("WORLD IF PRESENT OR ELSE"));
        
        

        value = hello.orElseThrow(IllegalArgumentException::new);
    }
}
