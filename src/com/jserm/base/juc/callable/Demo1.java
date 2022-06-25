package com.jserm.base.juc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// 比较两个类
// 实现runnable接口
class MyThread1 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":Runnable");
    }
}
// 实现callable接口, callable有返回值
class  MyThread2 implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + ":callable");
        return 200;
    }
}

public class Demo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Runnable
        MyThread1 AA = new MyThread1();
        new Thread(AA, "AA").start();
        // 因为Thread类只能传入Runnable接口，所以如果需要使用传入callable的实现，需要找到一个中间人
        // 可以使用FeatureTask来做中转
        FutureTask futureTask = new FutureTask<>(new MyThread2());
        new Thread(futureTask,"BB").start();
        while (!futureTask.isDone()){
            System.out.println("waiting");
        }
        System.out.println(futureTask.get());
    }
}
