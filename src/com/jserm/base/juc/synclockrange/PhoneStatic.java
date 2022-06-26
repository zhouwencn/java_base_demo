package com.jserm.base.juc.synclockrange;

import java.util.concurrent.TimeUnit;

public class PhoneStatic {
    public static synchronized void sendSMS() throws Exception {
        // 停留4秒
        TimeUnit.SECONDS.sleep(4);
        System.out.println("----sendSMS");
    }
    public static synchronized void sendEmail() throws Exception {
        System.out.println("----sendEmail");
    }

    public void getHello() {
        System.out.println("----getHello");
    }
}
