package com.jserm.base.lambda_demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) {

    }

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18),
            new Employee("王五", 20),
            new Employee("赵六", 30),
            new Employee("test", 100)
    );

    public List<Employee> filterEmployee(List<Employee> list, FilterInterface<Employee> filterInterface) {
        ArrayList<Employee> employees = new ArrayList<>();
        for (Employee employee : list
        ) {
            if (filterInterface.test(employee)) {
                employees.add(employee);
            }
        }
        return employees;
    }
    //最基本的操作，用FilterInterface实现类的策略模式
    @Test
    public void test() {
        List<Employee> list = filterEmployee(employees, new FilterInterfaceImpl());
        for (Employee item : list
        ) {
            System.out.println(item);
        }
    }

    @Test
    public void test2() {
        List<Employee> list = filterEmployee(employees, new FilterInterfaceImpl2());
        for (Employee item : list
        ) {
            System.out.println(item);
        }
    }

    //    ==============优化分割线，改为匿名内部类的方式来实现==================
    // 可以看到，使用匿名内部类的方式，可以不用写FilterInterface接口的实现类，直接使用匿名内部类完成
    @Test
    public void test3() {
        List<Employee> list = filterEmployee(employees, new FilterInterface<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getName().equals("test");
            }
        });
        for (Employee item : list
        ) {
            System.out.println(item);
        }
    }

    @Test
    public void test4() {
        List<Employee> list = filterEmployee(employees, new FilterInterface<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge().equals(30);
            }
        });
        for (Employee item : list
        ) {
            System.out.println(item);
        }
    }

    // ==============优化分割线，改为lambda表达式的方式来实现==================
    // 将匿名内部类改为lambda表达式来实现，因为filterEmployee的入参是一个接口，因此可以使用匿名内部类
    // 但是Java8新加了lambda表达式，因此可以将匿名内部类再次简化，改为
    @Test
    public void test5() {
        List<Employee> list = filterEmployee(employees, employee -> employee.getAge().equals(30));
        for (Employee item : list
        ) {
            System.out.println(item);
        }
    }
}
