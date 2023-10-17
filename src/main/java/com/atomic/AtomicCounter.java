package com.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private AtomicInteger ai = new AtomicInteger(0);
    
    public void incrment() {
        ai.incrementAndGet();
        System.out.println(ai.get());
    }
    
    public void decrement() {
        ai.incrementAndGet();
    }
    
    public int value() {
        return ai.get();
    }    
}
