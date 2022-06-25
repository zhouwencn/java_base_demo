package com.jserm.base.juc.synclockrange;

// PhoneStatic同步静态方法
// 调用sendsms额sendemail
// 这种情况不管有没有TimeUnit.SECONDS.sleep(4);都是先sendmessage在sendEmail
public class SyncLockRangeStatic {
    public static void main(String[] args) throws InterruptedException {
        PhoneStatic phoneStatic = new PhoneStatic();
        new Thread(() -> {
            try {
                phoneStatic.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "AA").start();
        Thread.sleep(100);
        new Thread(()->{
            try {
                phoneStatic.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "BB").start();
    }
}
