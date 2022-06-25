package com.jserm.base.juc.supportclass;

import java.util.concurrent.CountDownLatch;

// CountDownLatch类
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // 创建CountDownLatch对象，设置初始值
        // 防止最后一两个线程没走完，就锁门走人类
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
             new Thread(()->{
                 System.out.println(Thread.currentThread().getName()+ "号同学离开了教室");
                 // 计数 -1
                 countDownLatch.countDown();
             },String.valueOf(i)).start();
        }
        // 等待
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + ":班长锁门走人了");
    }
}
