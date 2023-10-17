package com.atomic;

import java.util.concurrent.CompletableFuture;

public class AtomicMain {

    public static void main(String[] args) {
        AtomicCounter ac = new AtomicCounter();
        
        CompletableFuture.runAsync(() -> ac.incrment());
        CompletableFuture.runAsync(() -> ac.incrment());
        CompletableFuture.runAsync(() -> ac.incrment());
        CompletableFuture.runAsync(() -> ac.incrment());
        CompletableFuture.runAsync(() -> ac.incrment());
        CompletableFuture.runAsync(() -> ac.incrment());
        CompletableFuture.runAsync(() -> ac.incrment());
        CompletableFuture.runAsync(() -> ac.incrment());
        CompletableFuture.runAsync(() -> ac.incrment());
        CompletableFuture.runAsync(() -> ac.incrment());

    }

}
