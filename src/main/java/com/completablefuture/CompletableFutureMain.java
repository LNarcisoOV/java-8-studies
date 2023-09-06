package com.completablefuture;

import java.util.concurrent.ExecutionException;

public class CompletableFutureMain {
    public static void main(String[] args) {
        System.out.println("---------------- Processing Synchronous ----------------");
        
        Store worten = new Store();
        Store amazon = new Store();
        Store leroyMerlin = new Store();
        Store ericeira = new Store();    

        long start = System.currentTimeMillis();
        
        worten.getPrice();
        amazon.getPrice();
        leroyMerlin.getPrice();
        ericeira.getPrice();
        
        System.out.println("Processing time synchronous: " + (System.currentTimeMillis() - start));
        
        
        System.out.println();
        System.out.println("---------------- Processing Asynchronous ----------------");
        
        
        start = System.currentTimeMillis();
        
        worten.getPriceAsync();
        amazon.getPriceAsync();
        leroyMerlin.getPriceAsync();
        ericeira.getPriceAsync();
        
        System.out.println("Do something value: "+ doSomething());
        
        System.out.println("Processing time Asynchronous: " + (System.currentTimeMillis() - start));
        
        
        System.out.println();
        System.out.println("---------------- Processing Asynchronous With Exception----------------");
        
        
        start = System.currentTimeMillis();
        
        try {
            worten.getPriceAsyncWithException().get();
            amazon.getPriceAsyncWithException().get();
            leroyMerlin.getPriceAsyncWithException().get();
            ericeira.getPriceAsyncWithException().get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } 
        
        System.out.println("Do something value: "+ doSomething());
        
        System.out.println("Processing time Asynchronous: " + (System.currentTimeMillis() - start));
    }
    
    private static int doSomething() {
        int output = 0;
        for(int i=0; i<1000000; i++) {
            output++;
        }
        return output;
    }
}
