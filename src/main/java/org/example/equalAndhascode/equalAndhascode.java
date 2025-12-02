package org.example.equalAndhascode;

import java.util.HashSet;
import java.util.Set;

public class equalAndhascode{

    public static void main(String[] args){
        Set<Employee> set1 = new HashSet<>();
        Employee emp1 = new Employee(1,"John",50000);
        Employee emp2 = new Employee(1,"John",50000);
        set1.add(emp1);
        set1.add(emp2);
        System.out.println("Set size: " + set1.size());
    }


}
