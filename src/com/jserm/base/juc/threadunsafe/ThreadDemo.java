package com.jserm.base.juc.threadunsafe;

import java.util.ArrayList;
import java.util.UUID;

public class ThreadDemo {
    public static void main(String[] args) {
        // 会产生集合线程安全问题
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                // 向集合中添加内容
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
