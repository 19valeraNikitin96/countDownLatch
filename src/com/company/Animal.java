package com.company;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Animal implements Runnable{
    private static int count = 0;
    private static Random random = new Random();
    private int number;
    private CountDownLatch countDownLatch;

    public Animal(CountDownLatch countDownLatch){
        number = ++count;
        this.countDownLatch = countDownLatch;
    }

    public void eat(){
        try {
            Thread.sleep(random.nextInt(2000)+1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(random.nextInt(5000)+1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Animal with number "+number+" near the bowl.");
        countDownLatch.countDown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Animal with number "+number+" started to eat");
        eat();
        System.out.println("Animal with number "+number+" finished to eat");
    }
}
