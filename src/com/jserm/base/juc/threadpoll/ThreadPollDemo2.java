package com.jserm.base.juc.threadpoll;

import java.util.concurrent.*;

// 自定义线程池创建
public class ThreadPollDemo2 {
    public static void main(String[] args) {
        ExecutorService threadPool1 = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
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
    }
}
