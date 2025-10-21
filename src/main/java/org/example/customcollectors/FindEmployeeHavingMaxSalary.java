package org.example.customcollectors;

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
                    } else {
                        System.out.println("Department: " + department + " has no employees.");
                    }
                }
        );
    }
}
