package org.example.playwithcollectors;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class FindEmployeeHavingMaxSalary{
    public static void main(String[] args){


        // Using Collectors.maxBy to find the maximum salary
         EmployeeUtils.getEmployees().stream().map(Employee::getSalary).max(Comparator.naturalOrder())
                .ifPresent(maxSalary -> System.out.println("Max Salary: " + maxSalary));

        final Optional<Employee> maxSal = EmployeeUtils.getEmployees().stream().max(Comparator.comparing(Employee::getSalary));
        if(maxSal.isPresent()){
            System.out.println("Employee with max salary: " + maxSal.get().getName() + " with salary: " + maxSal.get().getSalary());
        }

        final Optional<Employee> minSal = EmployeeUtils.getEmployees().stream().min(Comparator.comparing(Employee::getSalary));
        System.out.println("Employee with min salary using min with reversed comparator: " + minSal.get().getName() + " with salary: " + minSal.get().getSalary());

        final Optional<Double> minSal2 = EmployeeUtils.getEmployees().stream().map(Employee::getSalary).min(Comparator.naturalOrder());
        System.out.println("Min Salary using map and min: " + minSal2.get());
        // Using Collectors.reducing to find the employee with the maximum salary
        final Optional<Employee> maxSalaryEmployee = EmployeeUtils.getEmployees().stream()
                .collect(Collectors.reducing(BinaryOperator.maxBy(
                        Comparator.comparingDouble(Employee::getSalary))));

        // Print the employee with the maximum salary
        maxSalaryEmployee.ifPresent(emp -> System.out.println("Employee with max salary: " + emp.getName() + " with salary: " + emp.getSalary()));
        // Using Collectors.maxBy to find the employee with the maximum salary
        final Optional<String> s = EmployeeUtils.getEmployees().stream()
                .collect(Collectors.maxBy(
                        Comparator.comparing(Employee::getSalary))).map(emp -> emp.getName() + " with salary: " + emp.getSalary());

        final Optional<Employee> collect1 = EmployeeUtils.getEmployees().stream()
                .collect(Collectors.maxBy(
                        Comparator.comparing(Employee::getSalary)));
        if(collect1.isPresent()){
            System.out.println("Employee with max salary using Collectors.maxBy: " + collect1.get().getName() + " with salary: " + collect1.get().getSalary());
        }

        // Print the employee, department with the maximum salary
        final Map<String, Optional<Employee>> collect = EmployeeUtils.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                                               Collectors.reducing(BinaryOperator.maxBy(
                                                       Comparator.comparingDouble(Employee::getSalary)))));
        collect.entrySet().stream().forEach(
                entry -> {
                    String department = entry.getKey();
                    Optional<Employee> employee = entry.getValue();
                    if (employee.isPresent()) {
                        System.out.println("Department: " + department + ", Employee with max salary: " + employee.get().getName() + " with salary: " + employee.get().getSalary());
                    }
                    else {
                        System.out.println("Department: " + department + " has no employees.");
                    }
                }
        );
    }
}




