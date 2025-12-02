package org.example.programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayWithFilterAndMap{

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John Doe", 30, "New York", "IT", 70000, "john.doe@example.com", "1234567890", "123 Street", "Developer"),
                new Employee(2, "Jane Smith", 25, "Los Angeles", "HR", 60000, "jane.smith@example.com", "0987654321", "456 Avenue", "Manager"),
                new Employee(3, "Alice Johnson", 35, "New York", "Finance", 80000, "alice.johnson@example.com", "1122334455", "789 Boulevard", "Analyst")
        );

        // Filter employees based on city and map to FilteredEmployee
        final List<Employee> collect = employees.stream()
                .filter(emp -> "New York".equals(emp.getCity())) // Filter by city
                .map(emp -> {
                    return new Employee(emp.getId(),emp.getName(),emp.getCity(),emp.getDepartment(),emp.getSalary());
                }).collect(Collectors.toList());
        ;// Map to FilteredEmployee


        // Print the filtered employees
        collect.forEach(System.out::println);

        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst();
        final Map<String, List<Employee>> collect1 = employees.stream().collect(Collectors.groupingBy(Employee::getCity,Collectors.toList()));
        System.out.println("colect1 :::" + collect1);

        final Map<String, Employee> collect2 = employees.stream().collect(Collectors.toMap(Employee::getCity,emp -> emp , (emp1, emp2) -> emp1.getSalary() >= emp2.getSalary() ? emp1 : emp2));
    }
}
