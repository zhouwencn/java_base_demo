package com.jserm.base.lambda_demo;
/*
匿名内部类

注意：
匿名内部类还能用于接口上
 */
public class Demo1 {
    public static void main(String[] args) {
//        Child child = new Child();
//        child.eat();
//        child.look();

        // 换成匿名内部类实现

//        Person person = new Person() {
//            @Override
//            public void eat() {
//                System.out.println("匿名内部类，eat something");
//            }
//
//            @Override
//            public void look() {
//                System.out.println("handsome");
//            }
//        };
//        person.eat();
//        person.look();

//        匿名内部类使用多线程
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.print(i + " ");
                }
            }
        };
        thread.start();
//        ==============分割线==================
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.print(i + " ");
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
    }
}

abstract class Person {
    public abstract void eat();
    public abstract void look();
}

class Child extends Person {
    public void eat() {
        System.out.println("eat something");
    }

    @Override
    public void look() {
        System.out.println("handsome");
    }
}
