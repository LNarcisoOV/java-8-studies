package com.completablefuture;

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
        
        System.out.println("Processing time Asynchronous: " + (System.currentTimeMillis() - start));
    }
}
