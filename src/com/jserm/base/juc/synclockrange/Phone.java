package com.jserm.base.juc.synclockrange;

import java.util.concurrent.TimeUnit;

// synchronized锁的范围，如果是普通的方法加锁，则锁的是当前的this，即对象
// 如果是对static加锁，则锁的是当前的class类对象，不管new了几个对象，都是表示的class类对象

public class Phone {
    public synchronized void sendSMS() throws Exception {
        // 停留4秒
        // TimeUnit.SECONDS.sleep(4);
        System.out.println("----sendSMS");
    }
    public synchronized void sendEmail() throws Exception {
        System.out.println("----sendEmail");
    }

    public void getHello() {
        System.out.println("----getHello");
    }
}
