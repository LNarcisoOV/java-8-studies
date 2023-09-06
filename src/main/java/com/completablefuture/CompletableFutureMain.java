package com.completablefuture;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFutureMain {
    public static void main(String[] args) {
        
        Store worten = new Store();
        Store amazon = new Store();
        Store leroyMerlin = new Store();
        Store ericeira = new Store();    
        
        executeSynchronous(worten, amazon, leroyMerlin, ericeira);
        executeAsynchronous(worten, amazon, leroyMerlin, ericeira);
        executeAsynchronousWithException(worten, amazon, leroyMerlin, ericeira);
        executeAsynchronousSupplyAsync(worten, amazon, leroyMerlin, ericeira);
        executeAsynchronousParallelStream(worten, amazon, leroyMerlin, ericeira);
        
    }

    private static void executeAsynchronousParallelStream(Store worten, Store amazon,
            Store leroyMerlin, Store ericeira) {
        System.out.println("---------------- Processing Asynchronous Prallel Stream ----------------");
        
        long start = System.currentTimeMillis();
        
        List<Store> stores = List.of(worten, amazon, leroyMerlin, ericeira);
        List<Double> prices = stores.stream().map(store -> store.getPrice()).collect(Collectors.toList());
        
        System.out.println("Processing time with stream: " + (System.currentTimeMillis() - start));
        System.out.println(prices);
        
        start = System.currentTimeMillis();
        
        List<Double> pricesParallelStream = stores.parallelStream().map(store -> store.getPrice()).collect(Collectors.toList());
        
        System.out.println("Processing time with parallel stream: " + (System.currentTimeMillis() - start));
        System.out.println(pricesParallelStream);
        System.out.println();
    }

    private static void executeAsynchronousWithException(Store worten, Store amazon, Store leroyMerlin, Store ericeira) {
        System.out.println("---------------- Processing Asynchronous With Exception----------------");
                
        long start = System.currentTimeMillis();
        
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
        System.out.println();
    }

    private static void executeAsynchronous(Store worten, Store amazon, Store leroyMerlin, Store ericeira) {
        System.out.println("---------------- Processing Asynchronous ----------------");
        
        long start = System.currentTimeMillis();
        
        worten.getPriceAsync();
        amazon.getPriceAsync();
        leroyMerlin.getPriceAsync();
        ericeira.getPriceAsync();
        
        System.out.println("Do something value: "+ doSomething());
        System.out.println("Processing time Asynchronous: " + (System.currentTimeMillis() - start));
        System.out.println();
    }

    private static void executeSynchronous(Store worten, Store amazon, Store leroyMerlin, Store ericeira) {
        System.out.println("---------------- Processing Synchronous ----------------"); 

        long start = System.currentTimeMillis();
        
        worten.getPrice();
        amazon.getPrice();
        leroyMerlin.getPrice();
        ericeira.getPrice();
        
        System.out.println("Processing time synchronous: " + (System.currentTimeMillis() - start));
        System.out.println();
    }
    
    private static void executeAsynchronousSupplyAsync(Store worten, Store amazon, Store leroyMerlin, Store ericeira) {
        System.out.println("---------------- Processing Asynchronous Supply Asynchronous ----------------");
        
        long start = System.currentTimeMillis();
        
        worten.getPriceSupplyAsync();
        amazon.getPriceSupplyAsync();
        leroyMerlin.getPriceSupplyAsync();
        ericeira.getPriceSupplyAsync();
        
        System.out.println("Do something value: "+ doSomething());
        System.out.println("Processing time Asynchronous supply async: " + (System.currentTimeMillis() - start));
        System.out.println();
    }
    
    private static int doSomething() {
        int output = 0;
        for(int i=0; i<1000000; i++) {
            output++;
        }
        return output;
    }
}
