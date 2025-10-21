package org.example.hashmap.internalworking;


import org.example.hashmap.internalworking.beans.Employee;
import org.example.hashmap.internalworking.beans.Project;

import java.util.HashMap;

public class EmployeeSearch {

    public static void main(String a[]) {
        HashMap<Employee, Project> hm = new HashMap<Employee, Project>();
        //hm.put(new Employee("Sam", 100), new Project("Passport", 9));
       // hm.put(new Employee("Jimmy", 104), new Project("Passport", 9));
        hm.put(new Employee("Rahul", 109), new Project("Railway", 7));
        // hm.put(new Employee("Rahul", 109), new Project("BMTC", 7));
       // Employee key = new Employee("Rahul", 109);
       // System.out.println("Does key available? " + hm.containsKey(key));

        Project p = new Project("Railway", 7);
        System.out.println("Does Value available? " + hm.containsValue(p));
    }
}
