package com.jserm.base.juc.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class SyncLockDemo2 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(()->{
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "外层");
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "内层");
                } finally {
                    lock.unlock();
                }
            }finally {
                lock.unlock();
            }
        }, "t1").start();
    }
}
