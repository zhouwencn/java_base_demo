package com.jserm.base.juc.synclockrange;

// 第一种情况new 一个phone对象，然后调用sendsms额sendemail
// 这种情况不管有没有TimeUnit.SECONDS.sleep(4);都是先sendmessage在sendEmail
public class SyncLockRange {
    public static void main(String[] args) throws InterruptedException {
        Phone phone1 = new Phone();
        new Thread(() -> {
            try {
                phone1.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "AA").start();
        Thread.sleep(100);
        new Thread(()->{
            try {
                phone1.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "BB").start();
    }
}
