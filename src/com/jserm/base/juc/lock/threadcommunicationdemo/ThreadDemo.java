package com.jserm.base.juc.lock.threadcommunicationdemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 第一步，创建资源类，定义属性和操作方法
class Share {
    // 初始值
    private int number = 0;
    // 创建lock锁
    private Lock lock =  new ReentrantLock();
    private Condition condition = lock.newCondition();
    // +1的方法
    public  void increment() throws InterruptedException {
        // 上锁
        lock.lock();
        try {
            // 第二步，判断 干活 通知
            while(number != 0) { // 判断number值是否是0， 如果不是0，等待
                condition.await();
            }
            // 如果number是0，就+1操作
            number++;
            System.out.println(Thread.currentThread().getName() + "::" + number);
            // 通知其他线程
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
    // -1的方法
    // +1的方法
    public  void decrease() throws InterruptedException {
        lock.lock();
        // 第二步，判断 干活 通知
        try {
            while(number != 1) { // 判断number值是否是1， 如果不是1，等待
                condition.await();
            }
            // 如果number是1，就-1操作
            number--;
            System.out.println(Thread.currentThread().getName() + "::" + number);
            // 通知其他线程
            condition.signalAll();
        } finally {
            lock.unlock();
        }
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
