package com.stream;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class StreamMain {

    public static void main(String[] args) {
        // REDUCE WILL GET ALL ELEMENTS AND RETURN A SINGLE VALUE:
        // to use reduce properly, it has to be associative operation(sum, concat, etc...)
        // avoid the use of subtract or division
        
       int sum = List.of(1, 2, 3, 4 ,5).stream().reduce((n1, n2) -> n1 + n2).get();
       
       System.out.println("Simple reduce example: " + sum);
       
       
       sum = List.of(1, 2, 3, 4 ,5, 6).stream().reduce(0, (n1, n2) -> n1 + n2);
       
       System.out.println("Add reduce with identity value: " + sum);
       
       // Get min value with reduce
       OptionalDouble optDouble = 
               DoubleStream.of(1.1, 6.5, 8.8, 0.3, 3.3).reduce((n1, n2) -> Math.min(n1, n2));
       
       System.out.println(optDouble);

    }

}
