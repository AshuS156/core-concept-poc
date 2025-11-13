package org.example.importantinterviewquestions;


import java.util.Arrays;
import java.util.List;

public class IncreaseSalaryBasedOnGrade{
    public static void main(String[] args){
        Employee e1 = new Employee(101,Double.valueOf(70000),"A");
        Employee e2 = new Employee(111,Double.valueOf(50000),"B");
        Employee e3 = new Employee(1021,Double.valueOf(40000),"B");
        Employee e4 = new Employee(1112,Double.valueOf(100000),"D");

        List<Employee> empList = Arrays.asList(e1,e2,e3,e4);
        // Increase the salary of employee by 10% if grade is "B"

        empList.stream().filter(e -> "B".equalsIgnoreCase(e.getGrade())).forEach(e -> {
            e.setSalary(e.getSalary() * 1.10);
        });

        System.out.println(empList);
    }
}
