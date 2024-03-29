package com.completablefuture;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CompletableFuture;

public class Store {

    public double getPrice() {
        return showPrice();
    }
    
    public Future<Double> getPriceAsync(){
        CompletableFuture<Double> cfDouble = new CompletableFuture<>();
        
        new Thread (() -> {
            try {
                cfDouble.complete(showPrice());
            } catch(Exception e) {
                cfDouble.completeExceptionally(e);
            }
            
        }).start();
        
        return cfDouble;
    }
     
    public Future<Double> getPriceSupplyAsync(){
       return CompletableFuture.supplyAsync(this::showPrice);
    }
    
    public Future<Double> getPriceAsyncWithException(){
        CompletableFuture<Double> cfDouble = new CompletableFuture<>();
        
        new Thread (() -> {
            try {
                cfDouble.complete(showPriceWithException());
            } catch(Exception e) {
                cfDouble.completeExceptionally(e);
            }
            
        }).start();
        
        return cfDouble;
    }
    
    private double showPrice() {
        delay();
        double output = ThreadLocalRandom.current().nextDouble()*100;
        System.out.println("Price value: " + output);
        return output;
    }
    
    private double showPriceWithException() {
        System.out.println(1/0);
        return 1/0;
    }
    
    private static void delay() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
