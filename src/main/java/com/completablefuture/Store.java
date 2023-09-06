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
            cfDouble.complete(showPrice());
        }).start();
        
        return cfDouble;
    }
    
    private double showPrice() {
        delay();
        double output = ThreadLocalRandom.current().nextDouble()*100;;
        System.out.println("Price value: " + output);
        return output;
    }
    
    private static void delay() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
