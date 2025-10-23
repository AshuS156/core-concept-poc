package org.example.playwithcollectors;

import java.util.stream.Collectors;

public class CountEmployeeInEachDepartment{
    public static void main(String[] args){
        // Using Collectors.groupingBy to count the number of employees in each department
        EmployeeUtils.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()))
                .forEach((department, count) -> System.out.println("Department: " + department + ", Employee Count: " + count));
    }
}
