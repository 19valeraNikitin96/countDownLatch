package com.company;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {
        int amountOfAnimals = 5;
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ArrayList<Thread> animals = new ArrayList<>();
        for(int i = 0; i < amountOfAnimals; ++i){
            animals.add(new Thread(new Animal(countDownLatch)));
        }

        for(var animal : animals){
            animal.start();
        }
    }
}
