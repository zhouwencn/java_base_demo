package com.jserm.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Demo {
    public static  void  main(String[] args) {
        //InvocationHandler handler = (proxy, method, handlerArgs) -> {
        //    return null;
        //};
        InvocationHandler handler =  new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName());
                return null;
            }
        };
        Object o = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Comparable.class}, handler);
        System.out.println(o);
    }

}
