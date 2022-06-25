package com.jserm.base.juc.synclockrange;

// 第二种情况，new一个phone对象，然后调用sendsms和gethello方法
// 这种情况的结果就是，如果加了锁的sendsms方法中使用了TimeUnit.SECONDS.sleep(4)，那么就会先调用getHello方法在调用sendSms
// 如果没有使用TimeUnit.SECONDS.sleep(4)的话就会先执行AA线程的sendSMS的方法，在执行BB线程的getHello方法
public class SyncLockRange2 {
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
                phone1.getHello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "BB").start();
    }
}
