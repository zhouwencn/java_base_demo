package com.jserm.base.juc.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) {
        // 创建阻塞队列
        BlockingQueue<String> blockingQueue  = new ArrayBlockingQueue<>(3);
        // 第一组
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println(blockingQueue.element());
        // 在加会报错，因为规定长度是3
        // System.out.println(blockingQueue.add("d"));

        // 当阻塞队列空了的时候，在remove也会报错
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());

        // 还有offer和poll，put和take，具体可以自己百度
    }
}
