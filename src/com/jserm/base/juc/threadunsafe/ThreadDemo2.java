package com.jserm.base.juc.threadunsafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadDemo2 {
    public static void main(String[] args) {
        // 使用Collections解决集合线程安全问题
        // List<String> list = Collections.synchronizedList(new ArrayList<>());

        // 使用copyonwritearraylist解决线程集合线程安全问题
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                // 向集合中添加内容
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
