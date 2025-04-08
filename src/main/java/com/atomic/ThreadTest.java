package com.atomic;

import java.util.*;

class MyThread extends Thread {



public MyThread(String name) {

this.setName(name);

}



@Override

public void run() {

try {

sleep(100);

} catch (InterruptedException e) {

e.printStackTrace();

}

play();

}



private void play() {

System.out.print(getName());

System.out.print(getName());

}

}



public class ThreadTest {

public static void main(String args[]) throws InterruptedException {

    String temp = null;

    System.out.println(temp.valueOf(25));

    

}



}
