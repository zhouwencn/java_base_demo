package com.jserm.base.juc.sync.threadcommunicationdemo;

// 第一步，创建资源类，定义属性和操作方法
class Share {
    // 初始值
    private int number = 0;
    // +1的方法
    public synchronized void increment() throws InterruptedException {
        // 第二步，判断 干活 通知
        while(number != 0) { // 判断number值是否是0， 如果不是0，等待
            this.wait(); // 在哪里睡就会在哪里醒，wait也会释放锁
        }
        // 如果number是0，就+1操作
        number++;
        System.out.println(Thread.currentThread().getName() + "::" + number);
        // 通知其他线程
        this.notifyAll();
    }
    // -1的方法
    // +1的方法
    public synchronized void decrease() throws InterruptedException {
        // 第二步，判断 干活 通知
        while(number != 1) { // 判断number值是否是1， 如果不是1，等待
            this.wait(); // 在哪里睡就会在哪里醒，wait也会释放锁
        }
        // 如果number是1，就-1操作
        number--;
        System.out.println(Thread.currentThread().getName() + "::" + number);
        // 通知其他线程
        this.notifyAll();
    }
}

public class ThreadDemo {
    // 第三部，创建多个线程，调用资源类的操作方法
    public static void main(String[] args) {
        Share share = new Share();
        // 创建线程
        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                try {
                    share.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();
        // 创建线程
        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                try {
                    share.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
        // 创建线程
        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                try {
                    share.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();
        // 创建线程
        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                try {
                    share.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "DD").start();
    }
}
