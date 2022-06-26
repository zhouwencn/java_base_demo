package com.jserm.base.juc.reentrant;

public class SyncLockDemo {
    public static void main(String[] args) {
        // synchronized
        Object o = new Object();
        new Thread(()->{
            synchronized (o) {
                System.out.println(Thread.currentThread().getName() + "外层");
                synchronized (o) {
                    System.out.println(Thread.currentThread().getName() + "中层");
                    synchronized (o){
                        System.out.println(Thread.currentThread().getName() + "内层");
                    }
                }
            }
        }, "t1").start();
    }
}
