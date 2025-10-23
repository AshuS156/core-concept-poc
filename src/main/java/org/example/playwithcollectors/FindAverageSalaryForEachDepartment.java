package org.example.playwithcollectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 Question: WAP to find average salary for each department
  */
public class FindAverageSalaryForEachDepartment{
    public static void main(String[] args){
        final List<Employee> employees = EmployeeUtils.getEmployees();


        // Using Collectors.groupingBy to group employees by department and then calculating the average salary for each department
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary))
                )
                .forEach((department, averageSalary) -> System.out.println("Department: " + department + ", Average Salary: " + averageSalary));

        // Using Collectors.groupingBy to group employees by rating and then calculating the average salary for each rating
        final Map<String, Double> ratingSalaryMap = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getRating,Collectors.mapping(Employee::getSalary,Collectors.averagingDouble(Double::doubleValue))));

        System.out.println("Average Salary by Rating: " + ratingSalaryMap);

    }


}
