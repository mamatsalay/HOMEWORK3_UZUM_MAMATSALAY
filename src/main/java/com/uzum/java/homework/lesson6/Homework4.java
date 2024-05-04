package com.uzum.java.homework.lesson6;

import java.util.concurrent.Phaser;

public class Homework4 {

    static final Phaser START = new Phaser(8);
    static final int trackLength = 500000;

    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i <= 5; i++) {
            new Thread(new Car(i, (int) (Math.random() * 100 + 50))).start();
        }

        while (START.getArrivedParties() < 5) {
            System.out.println("Ждем старт!");
            Thread.sleep(100);
        }

        Thread.sleep(1000);
        System.out.println("На старт!");
        START.arriveAndDeregister();
        Thread.sleep(1000);
        System.out.println("Внимание!");
        START.arriveAndDeregister();
        Thread.sleep(1000);
        System.out.println("Марш!");
        START.arriveAndDeregister();
    }

    public static class Car implements Runnable {
        private int carNumber;
        private int carSpeed;

        public Car(int carNumber, int carSpeed) {
            this.carNumber = carNumber;
            this.carSpeed = carSpeed;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Автомобиль №%d подъехал к стартовой прямой.\n", carNumber);
                START.arriveAndAwaitAdvance();

                Thread.sleep(trackLength / carSpeed);
                System.out.printf("Автомобиль №%d финишировал!\n", carNumber);
            } catch (InterruptedException e) {}
        }
    }

}
