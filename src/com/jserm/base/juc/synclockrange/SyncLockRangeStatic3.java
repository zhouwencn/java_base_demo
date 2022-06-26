package com.jserm.base.juc.synclockrange;

// PhoneStatic同步静态方法,new 两个对象
// 这种情况的结果就是，不管有没有使用TimeUnit.SECONDS.sleep(4)，都是先phoneStatic.sendSMS();在 phoneStatic2.sendEmail();

public class SyncLockRangeStatic3 {
    public static void main(String[] args) throws InterruptedException {
        PhoneStatic phoneStatic = new PhoneStatic();
        PhoneStatic phoneStatic2 = new PhoneStatic();
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
                phoneStatic2.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "BB").start();
    }
}
