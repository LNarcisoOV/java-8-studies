package com.atomic;


public class ClassicCounter {
    private int counter = 0;
    
    public void incrment() {
        counter++;;
        System.out.println(counter);
    }
    
    public void decrement() {
        counter--;
    }
    
    public int value() {
        return counter;
    }    

}
