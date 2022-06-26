package com.jserm.base.juc.threadpoll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 关于线程与线程池的概念可以看下这篇文章： https://www.cnblogs.com/jing99/p/12670974.html

public class ThreadPollDemo1 {
    public static void main(String[] args) {
        // 一池n线程
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);

        // 一池一线程
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();

        // 一池可扩容线程
        ExecutorService threadPool3 = Executors.newCachedThreadPool();

        // 10个顾客请求
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool1.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool1.shutdown();
        }

        // 10个顾客请求
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool2.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool2.shutdown();
        }

        // 20个顾客请求
        try {
            for (int i = 1; i <= 20; i++) {
                threadPool3.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool3.shutdown();
        }
    }
}
