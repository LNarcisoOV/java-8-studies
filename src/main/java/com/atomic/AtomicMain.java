package com.atomic;

import java.util.concurrent.CompletableFuture;

public class AtomicMain {

    public static void main(String[] args) {
        System.out.println("Multithread with classic counter: ");
        ClassicCounter c = new ClassicCounter();
        
        CompletableFuture.runAsync(() -> c.incrment());
        CompletableFuture.runAsync(() -> c.incrment());
        CompletableFuture.runAsync(() -> c.incrment());
        CompletableFuture.runAsync(() -> c.incrment());
        CompletableFuture.runAsync(() -> c.incrment());
        CompletableFuture.runAsync(() -> c.incrment());
        CompletableFuture.runAsync(() -> c.incrment());
        CompletableFuture.runAsync(() -> c.incrment());
        CompletableFuture.runAsync(() -> c.incrment());
        CompletableFuture.runAsync(() -> c.incrment());

        System.out.println();
        System.out.println();
        System.out.println();
        
        System.out.println("Multithread with atomic counter: ");
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
