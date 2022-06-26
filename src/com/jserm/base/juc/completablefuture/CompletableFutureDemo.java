package com.jserm.base.juc.completablefuture;

import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            // 默认是ForkJoinPool.commonPool-worker-9----
            System.out.println(Thread.currentThread().getName() + "----");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(completableFuture.get());

        // 也可以指定线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(() -> {
            // 默认是ForkJoinPool.commonPool-worker-9----
            System.out.println(Thread.currentThread().getName() + "----");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },threadPool);
        System.out.println(completableFuture2.get());
        threadPool.shutdown();

        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            // 默认是ForkJoinPool.commonPool-worker-9----
            System.out.println(Thread.currentThread().getName() + "----");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello must return";
        });
        System.out.println(supplyAsync.get());  // 能拿到返回值

        //========================链式调用====================//
        // 有点像JS的Promise
        CompletableFuture.supplyAsync(()->{
            System.out.println("111");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "1111";
        }).whenComplete((v, e)->{
            if(e == null) {
                System.out.println(v);
            }
        });
    }
}
