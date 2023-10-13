package com.completablefuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureMain2 {
    
    
    
    public static void main(String... a) throws InterruptedException {
        System.out.println("Start");
        
        CompletableFuture.supplyAsync(() -> compute(5))
        .thenApply(value -> compute2(value))
        .thenApply(value -> value + value * 11)
        .thenApply(value -> value * Math.random())
        .thenAccept(System.out::println);

        System.out.println("End");
        
        System.out.println("Non blocking supply async example");
        
        System.out.println("-------");
        System.out.println("Example using thenCombine:");
        
        CompletableFuture<Integer> cf1 = createCompletableFutureInt(2);
        CompletableFuture<Integer> cf2 = createCompletableFutureInt(6);
        cf1.thenCombine(cf2, (r1, r2) -> r1 + r2)
        .thenAccept(sumOfValues -> {
            System.out.println(sumOfValues);
        });
        
    }
    
    private static int compute(int n) {
        return n * 10;
    }

    private static int compute2(Integer value) {
        return value * 2;
    } 
    
    private static CompletableFuture<Integer> createCompletableFutureInt(int d){
        return CompletableFuture.supplyAsync(() ->  compute(d));
    }
}
