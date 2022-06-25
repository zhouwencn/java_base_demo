package com.jserm.base.juc.supportclass;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    // 创建固定值
    private static final int NUMBER = 7;
    public static void main(String[] args) {
        // 创建CyclicBarrier
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER, () -> {
            System.out.println("集齐七棵龙珠召唤神龙");
        });
        // 集齐七棵龙珠的过程
        for (int i = 1; i <= 7; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName() + ":星龙珠");
                    // 等待
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
