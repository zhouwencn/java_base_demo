package com.jserm.base.lambda_demo;

@FunctionalInterface
public interface FilterInterface<T> {
    boolean test(T t);
}
