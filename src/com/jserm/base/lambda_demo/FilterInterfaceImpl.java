package com.jserm.base.lambda_demo;

public class FilterInterfaceImpl implements FilterInterface<Employee>{
    @Override
    public boolean test(Employee t) {
        return t.getAge() > 20;
    }
}
