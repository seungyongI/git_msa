package org.example;

public class Main {
    //java 는 single thread 로 이루어져 있지만 다중 thread 구현 가능
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        Thread thread2 = new Thread(runnable);
        thread2.start();

        for (int i = 0; i < 1000; i++) {
        Thread th1 = Thread.currentThread();
        System.out.println(th1.getName() + " " + i);
        }
    }
}