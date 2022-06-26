package com.jserm.base.juc.completablefuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + "come in");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task over";
        });
        new Thread(futureTask, "t1").start();

        // System.out.println(futureTask.get()); // futureTask.get()会造成程序运行阻塞，必须等到get到了才会往下执行，所以一定要把它放到代码的最后执行
        // 还有isDone方法，可以做轮询，具体可以参考Java jdk的api
        System.out.println(Thread.currentThread().getName() + "忙其他任务了");

        System.out.println(futureTask.get()); // futureTask.get()会造成程序运行阻塞，必须等到get到了才会往下执行，所以一定要把它放到代码的最后执行
    }
}
