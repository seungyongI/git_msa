package org.example;

class Counter {
    private int count = 0;

    // synchronized 예약어 : 여러 Method가 동시 작동을 안 하기에 동기적으로 됨
    synchronized public void increment() {
        count++;
    }

    synchronized public void decrement() {
        count--;
    }

//    public void increment() {
//        synchronized (this) {
//            count++;
//        }
//    }
//
//    public void decrement() {
//        synchronized (this) {
//            count--;
//        }
//    }
//
//    public void increment() {
//        count++;
//    }
//
//    public void decrement() {
//        count--;
//    }

    public int getCount() {
        return count;
    }
}

public class Ex03 {

    public static Counter counter = new Counter();

    public static void main(String[] args) throws InterruptedException {

        Runnable run1 = () -> {
            for (int i = 0; i < 1000; i++) {
//                System.out.println(Thread.currentThread().getName() + " " + i);
                counter.increment();
            }
        };
        Runnable run2 = () -> {
            for (int i = 0; i < 1000; i++) {
//                System.out.println(Thread.currentThread().getName() + " " + i);
                counter.decrement();
            }
        };

        Thread th1 = new Thread(run1);
        Thread th2 = new Thread(run2);

        th1.start();
        th2.start();

        th1.join();
        th2.join();

//        for (int i = 0; i < 1000; i++) {
//            System.out.println(Thread.currentThread().getName() + " " + i);
//        }

        System.out.println(counter.getCount());
    }
}