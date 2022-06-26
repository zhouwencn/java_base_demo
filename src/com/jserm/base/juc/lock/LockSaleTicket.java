package com.jserm.base.juc.lock;


import java.util.concurrent.locks.ReentrantLock;

// 1.创建资源类，定义属性和操作方法
class Ticket {
    // 票数
    private int number = 30;

    // 创建可重入锁
    private final ReentrantLock lock = new ReentrantLock();
    // 操作方法
    public void sale() {
        // 上锁
        lock.lock();

        // 判断是否有票
        try {
            if(number > 0) {
                System.out.println(Thread.currentThread().getName()+"卖出：" + (number--) + "剩下：" + number);
            }
        } finally {
            // 释放锁
            lock.unlock();
        }
    }
}
public class LockSaleTicket {
    // 2.创建多个线程，调用资源类的方法的操作方法
    public static void main(String[] args) {
        // 创建ticket对象
        Ticket ticket = new Ticket();
        // 创建三个线程
        new Thread(() -> {
            // 调用买票的方法
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "AA").start();
        new Thread(() -> {
            // 调用买票的方法
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "BB").start();
        new Thread(() -> {
            // 调用买票的方法
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "CC").start();
    }
}

