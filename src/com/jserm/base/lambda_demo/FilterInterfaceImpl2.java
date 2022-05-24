package com.jserm.base.lambda_demo;

public class FilterInterfaceImpl2 implements FilterInterface<Employee>{
    @Override
    public boolean test(Employee employee) {
        return employee.getName().equals("张三");
    }
}
